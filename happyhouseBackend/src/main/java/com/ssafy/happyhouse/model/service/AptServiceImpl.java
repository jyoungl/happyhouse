package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.Commercial;
import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.model.dto.SidoGugunCode;
import com.ssafy.happyhouse.model.dto.Subway;
import com.ssafy.happyhouse.model.mapper.HouseMapMapper;

@Service
public class AptServiceImpl implements AptService {
	
	@Autowired
	private HouseMapMapper houseMapMapper;

	@Override
	public List<SidoGugunCode> getSido() throws Exception {

		return houseMapMapper.getSido();
	}

	@Override
	public List<SidoGugunCode> getGugunInSido(String sido) throws Exception {

		return houseMapMapper.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfo> getDongInGugun(String gugun) throws Exception {
		return houseMapMapper.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfo> getAptInDong(String dong) throws Exception {
		List<HouseInfo> houseInfos = houseMapMapper.getAptInDong(dong);

		List<Subway> subways = houseMapMapper.getSubway(dong);

		// 집에서 가장 가까운 역 찾기 : 쿼리를 통해 읽어온 집 리스트 개수 만큼 반복
		for (HouseInfo houseInfo : houseInfos) {
			// 집에서 가장 가까운 지하철역까지의 최단 거리를 저장할 변수
			double minDis = Double.MAX_VALUE;
			// 집의 위도, 경도
			double houseLat = Double.parseDouble(houseInfo.getLat());
			double houseLng = Double.parseDouble(houseInfo.getLng());
			// 지하철 개수만큼 반복
			for (Subway subway : subways) {
				// 지하철역의 위도, 경도
				double subwayLat = subway.getLat();
				double subwayLng = subway.getLng();
				// 집으로부터 지하철 역까지의 거리를 저장할 변수
				double dist;
				// 세타 각도
				double theta = houseLng - subwayLng;
				// 삼각 함수를 이용하여 지구에서 위도 경도로 거리 구하기
				dist = Math.sin(Math.toRadians(houseLat)) * Math.sin(Math.toRadians(subwayLat))
						+ Math.cos(Math.toRadians(houseLat)) * Math.cos(Math.toRadians(subwayLat))
								* Math.cos(Math.toRadians(theta));
				
				dist = Math.acos(dist);
				// 위도 기준 각도
				dist = Math.toDegrees(dist);
				// 해리 구하기 => 마일로 치환
				dist = dist * 60 * 1.1515;
				
				// 거리 단위 킬로미터 적용 
				dist = dist * 1.609344;
				// 거리가 최소인 경우, houseInfo Dto의 최단 거리와 최단 거리 지하철역 갱신
				if (minDis > dist) {
					minDis = dist;
					houseInfo.setSubwayName(subway.getSubwayName() + " " + subway.getLine() + "호선");
					houseInfo.setSubwayDistance(String.format("%.3fkm", minDis));
				}
			}
		}

		return houseInfos;
	}
	
	@Override
	public List<HouseInfo> getAptInDate(String dong, String minyear, String maxyear) throws Exception {
		List<HouseInfo> houseInfos = houseMapMapper.getAptInDate(dong, minyear, maxyear);

		List<Subway> subways = houseMapMapper.getSubway(dong);

		// 집에서 가장 가까운 역 찾기 : 쿼리를 통해 읽어온 집 리스트 개수 만큼 반복
		for (HouseInfo houseInfo : houseInfos) {
			// 집에서 가장 가까운 지하철역까지의 최단 거리를 저장할 변수
			double minDis = Double.MAX_VALUE;
			// 집의 위도, 경도
			double houseLat = Double.parseDouble(houseInfo.getLat());
			double houseLng = Double.parseDouble(houseInfo.getLng());
			// 지하철 개수만큼 반복
			for (Subway subway : subways) {
				// 지하철역의 위도, 경도
				double subwayLat = subway.getLat();
				double subwayLng = subway.getLng();
				// 집으로부터 지하철 역까지의 거리를 저장할 변수
				double dist;
				// 세타 각도
				double theta = houseLng - subwayLng;
				// 삼각 함수를 이용하여 지구에서 위도 경도로 거리 구하기
				dist = Math.sin(Math.toRadians(houseLat)) * Math.sin(Math.toRadians(subwayLat))
						+ Math.cos(Math.toRadians(houseLat)) * Math.cos(Math.toRadians(subwayLat))
								* Math.cos(Math.toRadians(theta));
				
				dist = Math.acos(dist);
				// 위도 기준 각도
				dist = Math.toDegrees(dist);
				// 해리 구하기 => 마일로 치환
				dist = dist * 60 * 1.1515;
				
				// 거리 단위 킬로미터 적용 
				dist = dist * 1.609344;
				// 거리가 최소인 경우, houseInfo Dto의 최단 거리와 최단 거리 지하철역 갱신
				if (minDis > dist) {
					minDis = dist;
					houseInfo.setSubwayName(subway.getSubwayName() + " " + subway.getLine() + "호선");
					houseInfo.setSubwayDistance(String.format("%.3fkm", minDis));
				}
			}
		}

		return houseInfos;
	}
	
	@Override
	public List<Commercial> getShopInDong(String dong) throws Exception{
		return houseMapMapper.getShopInDong(dong);
	}

	@Override
	public List<Commercial> getDongInGugunByShop(String gugun) throws Exception {
		return houseMapMapper.getDongInGugunByShop(gugun);
	}

	@Override
	public List<Subway> getSubway(String dong) throws Exception {
		return houseMapMapper.getSubway(dong);
	}
}
