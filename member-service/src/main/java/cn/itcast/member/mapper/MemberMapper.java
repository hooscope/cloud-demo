package cn.itcast.member.mapper;


import cn.itcast.member.pojo.Member;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
    
    @Select("select * from tb_member where name = #{username}")
    Member findByName(@Param("username") String username);
}