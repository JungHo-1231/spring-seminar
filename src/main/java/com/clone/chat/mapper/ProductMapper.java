package com.clone.chat.mapper;

import com.clone.chat.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductDto> getAllProduct() throws Exception;
    void insertProduct(ProductDto productDto) throws Exception;
}
