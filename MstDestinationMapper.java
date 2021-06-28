package jp.co.internous.kabuki.model.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.kabuki.model.domain.MstDestination;

@Mapper
public interface MstDestinationMapper {
	
	
	
	@Insert("insert into mst_destination(id,user_id,family_name,first_name,tel_number,address) values(#{id},#{userId},#{familyName},#{firstName},#{telNumber},#{address})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	long insert(MstDestination mstDestination);
	
	@Update("update mst_destination set status=0 updated_at=now() where id=#{destinationId}")
	int delete(@Param("destinationId") long destinationId);
	
	@Select("SELECT id FROM mst_destination WHERE id=#{id}")
	void findById(@Param("id") long id);
	
	@Select("SELECT * FROM mst_destination WHERE user_id=#{userId} AND status=1 ORDER BY id ASC")
	List<MstDestination> findByUserId(@Param("userId") long userId);
	
}
