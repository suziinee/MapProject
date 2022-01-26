package service;

import java.util.ArrayList;

import exception.RouteDupulicatedException;
import exception.RouteNameNotFoundException;
import exception.SinglePathwayException;
import exception.TransportationDupulicatedException;
import exception.TransportationNotFoundException;
import model.dto.Bus;
import model.dto.Route;
import model.dto.Subway;
import model.dto.Transportation;
import view.EndFailView;

public class ProjectMapService {

	private static ProjectMapService instance = new ProjectMapService();
	private ProjectMapService() {}
	public static ProjectMapService getInstance() {
		return instance;
	}
	
	
	
	
	/* 저장 배열 생성 */
	
	private ArrayList<Route> routeList = new ArrayList<Route>();
	private ArrayList<Transportation> transportationList = new ArrayList<Transportation>();
	
	
	
	
	/* 검색 및 반환 메소드 */
	
	public ArrayList<Route> getRouteList() {
		return routeList;
	}
	
	
	public Route getRoute(String routeName) 
		throws RouteNameNotFoundException {
		
		for (Route r : routeList) {
			if (routeName.equals(r.getName())) {
				return r;
			}
		}
		throw new RouteNameNotFoundException();
	}
	
	
	public Transportation getTransportation(String transportationId) 
		throws TransportationNotFoundException {
		
		for (Transportation t : transportationList) {
			if (transportationId.equals(t.getId())) {
				return t;
			}
		}
		throw new TransportationNotFoundException();
	}
	
	
	
	
	/* 추가 메소드 */
	
	public void transportationInsert(Transportation newTransportation) 
		throws TransportationDupulicatedException {
		
		for (Transportation t : transportationList) {
			if (newTransportation == t) {
				throw new TransportationDupulicatedException();
			}
		}
		transportationList.add(newTransportation);
	}
	
	
	public void routeInsert(Route newRoute) 
		throws RouteDupulicatedException {
		
		for (Route r : routeList) {
			if (newRoute == r) {
				throw new RouteDupulicatedException();
			}
		}
		routeList.add(newRoute);
	}
	
	
	
	
	/* 수정 메소드 */
	
	public void routeABUpdate(String routeName, Object newTransportation) 
		throws SinglePathwayException {
		
		for (Route r : routeList) {
			if (routeName.equals(r.getName())) {
				if (r.getTransportation() != null) {
					throw new SinglePathwayException("A부터 C까지 한번에 가는 루트입니다.");
				}else {
					r.setTransportation1(newTransportation);
					return;
				}
			}
		}
		EndFailView.failView("업데이트하려는 루트를 찾지 못했습니다.");
	}
	
	
	public void priceABUpdate(String transportationId, int newPrice) 
		throws TransportationNotFoundException {
		
		for (Transportation t : transportationList) {
			if (transportationId.equals(t.getId())) {
				t.setPriceAB(newPrice);
				return;
			}
		}
		throw new TransportationNotFoundException();
	}
		
	
	
	
	/* 삭제 메소드 */ 
	
	public boolean routeDelete(String routeName) {
		int count = routeList.size();
		
		for (int i = 0; i < count; i++) {
			if (routeName.equals(routeList.get(i).getName())) {
				routeList.remove(i);
				return true;
			}
		}
		return false;
	}
		
}
