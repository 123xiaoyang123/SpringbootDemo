package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface UserMapper {


    @Select("select * from usertable")
    List<User> selectUser() throws Exception;

    @Insert("insert into usertable values (default ,#{uName},#{uPwd},#{uType},#{uMemo})")
    int addUer(User user) throws Exception;

    @Select("select * from usertable where uName=#{uName} and uPwd=#{uPwd}")
    User login(String uName, String uPwd) throws Exception;

    @Delete("delete from usertable where uCode=#{id}")
    void delete(int id) throws Exception;

    @Update("update usertable\n" +
            "        set uName=#{uName},\n" +
            "            uPwd=#{uPwd},\n" +
            "            uType=#{uType},\n" +
            "            uMemo=#{uMemo}\n" +
            "        where uCode=#{uCode}")
    void update(User user) throws Exception;

    @Select("select * from usertable where uCode=#{id}")
    User select(int id) throws Exception;

}
