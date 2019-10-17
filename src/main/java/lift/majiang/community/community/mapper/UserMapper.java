package lift.majiang.community.community.mapper;

import lift.majiang.community.community.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("INSERT INTO user(name,account_id,token,gmt_create,gmt_modified) VALUES(#{name},#{account_Id},#{token},#{gmt_create},#{gmt_modified})")
    void insert(User user);
}
