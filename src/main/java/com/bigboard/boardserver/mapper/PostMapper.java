package com.bigboard.boardserver.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bigboard.boardserver.dto.PostDTO;

import java.util.List;

@Mapper
public interface PostMapper {
    public int register(PostDTO postDTO);

    public List<PostDTO> selectMyProducts(int accountId);

    public void updateProducts(PostDTO postDTO);

    public void deleteProduct(int productId);
}