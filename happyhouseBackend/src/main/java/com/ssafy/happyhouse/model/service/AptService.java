package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.Commercial;
import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.model.dto.SidoGugunCode;

public interface AptService {

	List<SidoGugunCode> getSido() throws Exception;
	List<SidoGugunCode> getGugunInSido(String sido) throws Exception;
	List<HouseInfo> getDongInGugun(String gugun) throws Exception;
	List<HouseInfo> getAptInDong(String dong) throws Exception;
	List<HouseInfo> getAptInDate(String dong, String minyear, String maxyear) throws Exception;
	List<Commercial> getShopInDong(String dong) throws Exception;
	List<Commercial> getDongInGugunByShop(String gugun) throws Exception;
}
