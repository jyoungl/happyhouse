package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.Commercial;
import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.model.dto.SidoGugunCode;
import com.ssafy.happyhouse.model.dto.Subway;

@Mapper
public interface HouseMapMapper {

	List<SidoGugunCode> getSido() throws SQLException;
	List<SidoGugunCode> getGugunInSido(String sido) throws SQLException;
	List<HouseInfo> getDongInGugun(String gugun) throws SQLException;
	List<HouseInfo> getAptInDong(String dong) throws SQLException;
	List<HouseInfo> getAptInDate(@Param("dong") String dong,@Param("year") String year,@Param("month") String month) throws SQLException;
	List<Commercial> getShopInDong(String dong) throws SQLException;
	List<Commercial> getDongInGugunByShop(String gugun) throws SQLException;
	List<Subway> getSubway(String dong) throws SQLException;
}
