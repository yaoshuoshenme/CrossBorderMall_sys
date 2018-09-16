package com.edu.service.impl;

import com.edu.mapper.BackuserMapper;
import com.edu.pojo.Backuser;
import com.edu.service.BackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BackUserServiceImpl implements BackUserService {

    @Autowired
    private BackuserMapper bm;

    @Override
    public Backuser selctByName(String bname,String bpassword) {

        return bm.selectByName(bname, bpassword);
    }
}
