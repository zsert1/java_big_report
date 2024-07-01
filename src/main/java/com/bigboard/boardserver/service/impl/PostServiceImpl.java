package com.bigboard.boardserver.service.impl;

import java.util.List;

import com.bigboard.boardserver.dto.PostDTO;
import com.bigboard.boardserver.service.PostService;

public class PostServiceImpl implements PostService{

    @Override
    public void register(String id, PostDTO postDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public List<PostDTO> getMyProducts(int accountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMyProducts'");
    }

    @Override
    public void updateProducts(PostDTO postDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProducts'");
    }

    @Override
    public void deleteProduct(int userId, int productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

}
