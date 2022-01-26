package service;

import java.util.ArrayList;
import java.util.Optional;

import exception.RouteDupulicatedException;
import exception.RouteNameNotFoundException;
import exception.SinglePathwayException;
import exception.TransportationDupulicatedException;
import exception.TransportationNotFoundException;
import model.dto.Route;
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
		
		Optional<Route> opt = routeList.stream().filter(r -> 
				r.getName().equals(routeName)).findAny();
		
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new RouteNameNotFoundException();
	}
	
	
	public Transportation getTransportation(String transportationId) 
		throws TransportationNotFoundException {
		
		Optional<Transportation> opt = transportationList.stream().filter(t -> 
				t.getId().equals(transportationId)).findAny();
		
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new TransportationNotFoundException();
	}
	
	
	
	
	/* 추가 메소드 */
	
	public void transportationInsert(Transportation newTransportation) 
		throws TransportationDupulicatedException {
		
		boolean anyMatch = transportationList.stream().anyMatch(t -> 
				t.getId().equals(newTransportation.getId()));
		
		if (anyMatch) {
			throw new TransportationDupulicatedException();
		}
		transportationList.add(newTransportation);
	}
	
	
	public void routeInsert(Route newRoute) 
		throws RouteDupulicatedException {
		
		boolean anyMatch = routeList.stream().anyMatch(r -> 
		r.getName().equals(newRoute.getName()));
		
		if (anyMatch) {
			throw new RouteDupulicatedException();
		}
		routeList.add(newRoute);
	}
	
	
	
	
	/* 수정 메소드 */
	
	public void routeABUpdate(String routeName, Object newTransportation) 
		throws SinglePathwayException {
		
		Optional<Route> opt = routeList.stream().filter(r -> 
				r.getName().equals(routeName)).findAny();
		
		if (opt.isPresent()) {
			opt.get().setTransportation1(newTransportation);
			return;
		}
		EndFailView.failView("업데이트하려는 루트를 찾지 못했습니다.");
	}
	
	
	public void priceABUpdate(String transportationId, int newPrice) 
		throws TransportationNotFoundException {
		
		Optional<Transportation> opt = transportationList.stream().filter(t -> 
		t.getId().equals(transportationId)).findAny();

		if (opt.isPresent()) {
			opt.get().setPriceAB(newPrice);
			return;
		}
		throw new TransportationNotFoundException();
	}
		
	
	
	
	/* 삭제 메소드 */ 
	
	public boolean routeDelete(String routeName) {
		
		Optional<Route> opt = routeList.stream().filter(r -> 
			r.getName().equals(routeName)).findAny();
		
		if (opt.isPresent()) {
			routeList.remove(opt.get());
			return true;
		}
		return false;
	}
		
}
