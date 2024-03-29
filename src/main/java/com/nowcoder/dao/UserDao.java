package com.nowcoder.dao;

import com.nowcoder.model.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by lenovo on 2019/7/15.
 */
@Mapper
public interface UserDao {
    String TABLE_NAME = "user";
    String INSET_FIELDS = " name,password,salt,head_url";
    String SELECT_FILEDS = "id,name,password,salt,head_url";
    @Insert({"insert into "+ TABLE_NAME +"("+ INSET_FIELDS,
            ") values (#{name},#{password},#{salt},#{headUrl})"})
    public int addUser(User user);

    @Select({"select ", SELECT_FILEDS, " from ", TABLE_NAME, " where id=#{id}"})
    User selectById(int id);

    @Update({"update ", TABLE_NAME, " set password=#{password} where id=#{id}"})
    void updatePassword(User user);

    @Delete({"delete from ", TABLE_NAME, " where id=#{id}"})
    void deleteById(int id);
}
