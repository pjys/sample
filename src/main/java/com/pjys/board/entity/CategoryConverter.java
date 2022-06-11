package com.pjys.board.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category attribute) {
        return null;
        // return attribute.getValue();
    }

    @Override
    public Category convertToEntityAttribute(String dbData) {
        return null;
        // return Category.enumOf(dbData);
    }
}
