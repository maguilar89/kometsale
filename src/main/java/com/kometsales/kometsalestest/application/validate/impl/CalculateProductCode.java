package com.kometsales.kometsalestest.application.validate.impl;

import com.kometsales.kometsalestest.application.validate.CalculateProduct;
import com.kometsales.kometsalestest.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculateProductCode implements CalculateProduct {
    
    private static final String SEPARATOR_WORDS = "-";
    private static final String CHARACTER_SPLIT_CHAIN = " ";

    private static final BigDecimal PERCENT_TO_CALCULATE_PRICE = new BigDecimal(100);

    private static final BigDecimal VALUE_TO_CALCULATE_FINAL_FREIGHT = new BigDecimal(1728);

    @Override
    public String calculate(String productName) {

        String[] chain = getWordInsideOf(productName);
        StringBuilder resultWord = new StringBuilder();
        
        for(String wordPart : chain){
            resultWord.append(getWordConverted(wordPart)).append(SEPARATOR_WORDS);
        }
        return resultWord.deleteCharAt(resultWord.length()-1).toString();
    }

    @Override
    public BigDecimal calculatePrice(String basePriceString, BigDecimal markDown) {
        BigDecimal basePrice = getBigDecimalValue(basePriceString);
        return basePrice.subtract(basePrice.multiply(markDown.divide(PERCENT_TO_CALCULATE_PRICE)));
    }

    @Override
    public List<Product> calculateFinalFreight(List<Map<String, Object>> inventories) {

       return inventories.stream().map(result->{
            BigDecimal width = getBigDecimalValue(result.get("width").toString());
            BigDecimal height = getBigDecimalValue(result.get("height").toString());
            BigDecimal length = getBigDecimalValue(result.get("length").toString());
            BigDecimal cubesPerCarrier = getBigDecimalValue(result.get("cubesPerCarrier").toString());
            BigDecimal pack = getBigDecimalValue(result.get("pack").toString());
            BigDecimal freshCutValue = getBigDecimalValue(result.get("freshCutValue").toString());

            BigDecimal cubesPerBox = calculateCubesPerBox(width,height,length);

            BigDecimal outboundFreight = calculateOutboundFreight(cubesPerCarrier,cubesPerBox,pack);

            BigDecimal finalFreight = calculateFinalFreight(freshCutValue,outboundFreight);

            return Product.
                    builder()
                    .name(result.get("product").toString())
                    .basePrice(getBigDecimalValue(result.get("basePrice").toString()))
                    .finalFreight(finalFreight)
                    .build();
        }).collect(Collectors.toList());

    }

    private BigDecimal calculateCubesPerBox(BigDecimal width, BigDecimal height,BigDecimal length){
        BigDecimal result = width.multiply(height).multiply(length);
        return result.divide(VALUE_TO_CALCULATE_FINAL_FREIGHT, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateOutboundFreight(BigDecimal cubesPerCarrier, BigDecimal cubesPerBox,BigDecimal pack){
        BigDecimal result = cubesPerCarrier.multiply(cubesPerBox);
        return result.divide(pack, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateFinalFreight(BigDecimal freshCutValue, BigDecimal outboundFreight){
        BigDecimal result = freshCutValue.divide(PERCENT_TO_CALCULATE_PRICE, RoundingMode.HALF_UP);
        return result.multiply(outboundFreight);
    }

    private BigDecimal getBigDecimalValue(String stringNumber) {
        try {
            return new BigDecimal(stringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The string cannot be converted to a BigDecimal: " + stringNumber, e);
        }
    }

    private String[] getWordInsideOf(String word) {
        return word.split(CHARACTER_SPLIT_CHAIN);
    }

    /**
     *
     * @param wordInside
     * @return
     */
    private String getWordConverted(String wordInside) {
        char firstLetter = wordInside.charAt(0);
        char lastLetter = wordInside.charAt(wordInside.length() - 1);
        int size = wordInside.length() -2;
        return String.format("%c%d%c", firstLetter, size,lastLetter).trim();
    }

}