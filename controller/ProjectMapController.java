package controller;

import java.util.Optional;

import exception.RouteDupulicatedException;
import exception.RouteNameNotFoundException;
import exception.SinglePathwayException;
import exception.TransportationDupulicatedException;
import exception.TransportationNotFoundException;
import model.dto.Route;
import model.dto.Transportation;
import service.ProjectMapService;
import view.EndFailView;
import view.EndView;

public class ProjectMapController {


	private static ProjectMapController instance = new ProjectMapController();
	private ProjectMapController() {}
	public static ProjectMapController getInstance() {
		return instance;
	}
	private ProjectMapService service = ProjectMapService.getInstance();
	
	
	
	
	/* 검색 및 반환 메소드 */
	
	public void getRouteList() {
		EndView.routeListView(service.getRouteList());
	}
	
	
	public void getRoute(String routeName) {
		
		try {
			EndView.routeView(service.getRoute(routeName));
		} catch(RouteNameNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView("해당 Route를 찾지 못했습니다.");
		}
	}
	
	
	public void getTransportation(String transportationId) {
		
		try {
			EndView.transportationView(service.getTransportation(transportationId));
		} catch(TransportationNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView("해당 교통수단을 찾지 못했습니다.");
		}
	}
	
	
	
	
	/* 추가 메소드 */
	
	public void transportationInsert(Transportation newTransportation) {
		Optional<Transportation> opt = Optional.ofNullable(newTransportation);
		
		opt.ifPresentOrElse(data -> {
			try {
				service.transportationInsert(data);
			} catch(TransportationDupulicatedException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		}, () -> {
			System.out.println("추가하려는 교통수단 정보를 제대로 입력하세요.");
		});
	}
	
	
	public void routeInsert(Route newRoute) {
		Optional<Route> opt = Optional.ofNullable(newRoute);
		
		opt.ifPresentOrElse(data -> {
			try {
				service.routeInsert(data);
			} catch(RouteDupulicatedException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		}, () -> {
			System.out.println("추가하려는 Route 정보를 제대로 입력하세요.");
		});
	}
	
	
	
	
	/* 수정 메소드, Controller에서 반환 추가 */
	
	public void routeABUpdate(String routeName, Object newTransportation) {
		Optional<String> optName = Optional.ofNullable(routeName);
		Optional<Object> optT = Optional.ofNullable(newTransportation);
		
		if (optName.isPresent() && optT.isPresent()) {
			try {
				service.routeABUpdate(routeName, newTransportation);
				EndView.successView(routeName + "의 AB 구간 교통수단 수정이 완료되었습니다."); 
				System.out.println("수정된 Route 정보 : ");
				getRoute(routeName);
			} catch(SinglePathwayException e) {
				e.printStackTrace();
				EndFailView.failView("AB 구간의 교통수단을 수정할 수 없는 SingleRoute 입니다.");
			}
		}else {
			System.out.println("수정 정보를 제대로 입력하세요.");
		}
	}
	
	
	public void priceABUpdate(String transportationId, int newPrice) {
		Optional<String> optId = Optional.ofNullable(transportationId);
		Optional<Integer> optPrice = Optional.ofNullable(newPrice);
		
		if (optId.isPresent() && optPrice.isPresent()) {
			try {
				service.priceABUpdate(transportationId, newPrice);
				EndView.successView(transportationId + "의 AB 구간 요금 수정이 완료되었습니다.");
				System.out.println("수정된 교통수단 정보 : ");
				getTransportation(transportationId);
			} catch(TransportationNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView("수정하고자 하는 교통수단을 찾지 못했습니다.");
			}
		}else {
			EndFailView.failView("수정할 요금과 교통수단의 정보를 제대로 입력하세요.");
		}
	}
	
	
	
	
	/* 삭제 메소드 */
	
	public void routeDelete(String routeName) {
		Optional<String> opt = Optional.ofNullable(routeName);
		boolean result = service.routeDelete(routeName);
		
		opt.ifPresentOrElse(data -> {
			if (result) {
				EndView.successView(routeName + "삭제가 완료되었습니다.");
			}else {
				EndFailView.failView("삭제할 Route를 찾지 못했습니다.");
			}
		}, () -> {
			EndFailView.failView("삭제할 Route 이름을 제대로 입력하세요.");
		});
	}
	
	
	
}

