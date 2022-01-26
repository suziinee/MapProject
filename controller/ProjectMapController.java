package controller;

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
	
	
	
	
	/* �˻� �� ��ȯ �޼ҵ� */
	
	public void getRouteList() {
		EndView.routeListView(service.getRouteList());
	}
	
	
	public void getRoute(String routeName) {
		
		try {
			EndView.routeView(service.getRoute(routeName));
		} catch(RouteNameNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView("�ش� Route�� ã�� ���߽��ϴ�.");
		}
	}
	
	
	public void getTransportation(String transportationId) {
		
		try {
			EndView.transportationView(service.getTransportation(transportationId));
		} catch(TransportationNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView("�ش� ��������� ã�� ���߽��ϴ�.");
		}
	}
	
	
	
	
	/* �߰� �޼ҵ� */
	
	public void transportationInsert(Transportation newTransportation) {
		
		if (newTransportation != null ) {
			try {
				service.transportationInsert(newTransportation);
			} catch(TransportationDupulicatedException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		}else {
			System.out.println("�߰��Ϸ��� ������� ������ ����� �Է��ϼ���.");
		}
	}
	
	
	public void routeInsert(Route newRoute) {
		
		if (newRoute != null ) {
			try {
				service.routeInsert(newRoute);
			} catch(RouteDupulicatedException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		}else {
			System.out.println("�߰��Ϸ��� Route ������ ����� �Է��ϼ���.");
		}
	}
	
	
	
	
	/* ���� �޼ҵ�, Controller���� ��ȯ �߰� */
	
	public void routeABUpdate(String routeName, Object newTransportation) {
		
		if (routeName != null && newTransportation != null) {
			try {
				service.routeABUpdate(routeName, newTransportation);
				EndView.successView(routeName + "�� AB ���� ������� ������ �Ϸ�Ǿ����ϴ�."); 
				System.out.println("������ Route ���� : ");
				getRoute(routeName);
			} catch(SinglePathwayException e) {
				e.printStackTrace();
				EndFailView.failView("AB ������ ��������� ������ �� ���� SingleRoute �Դϴ�.");
			}
		}else {
			System.out.println("���� ������ ����� �Է��ϼ���.");
		}
	}
	
	
	public void priceABUpdate(String transportationId, int newPrice) {
		
		if (transportationId != null && newPrice != 0) {
			try {
				service.priceABUpdate(transportationId, newPrice);
				EndView.successView(transportationId + "�� AB ���� ��� ������ �Ϸ�Ǿ����ϴ�.");
				System.out.println("������ ������� ���� : ");
				getTransportation(transportationId);
			} catch(TransportationNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView("�����ϰ��� �ϴ� ��������� ã�� ���߽��ϴ�.");
			}
		}else {
			EndFailView.failView("������ ��ݰ� ��������� ������ ����� �Է��ϼ���.");
		}
	}
	
	
	
	
	/* ���� �޼ҵ� */
	
	public void routeDelete(String routeName) {
		boolean result = service.routeDelete(routeName);
		
		if (routeName != null) {
			if (result) {
				EndView.successView(routeName + "������ �Ϸ�Ǿ����ϴ�.");
			}else {
				EndFailView.failView("������ Route�� ã�� ���߽��ϴ�.");
			}
		}else {
			EndFailView.failView("������ Route �̸��� ����� �Է��ϼ���.");
		}
	}
	
	
	
}
