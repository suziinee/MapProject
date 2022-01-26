package view;

import controller.ProjectMapController;
import model.dto.Bus;
import model.dto.Route;
import model.dto.Subway;

public class StartView {

	public static void main(String[] args) {
		
		Bus bus1 = new Bus("관악 02", 1250, 900, 2000);
		Bus bus2 = new Bus("동작 03", 900, 1300, 2100);
		Subway subway1 = new Subway("2호선", 1350, 1250, 2500);
		Subway subway2 = new Subway("6호선", 1250, 1400, 2600);
		
		Route route1 = new Route("route1", bus1, subway1);
		Route route2 = new Route("route2", bus1, subway2);
		Route route3 = new Route("route3", bus2, subway1);
		Route route4 = new Route("route4", bus2, subway2);
		Route route5 = new Route("route5", subway1, bus1);
		Route route6 = new Route("route6", subway1, bus2);
		Route route7 = new Route("route7", subway2, bus1);
		Route route8 = new Route("route8", subway2, bus2);
		Route route9 = new Route("route9", bus1);
		Route route10 = new Route("route10", bus2);
		Route route11 = new Route("route11", subway1);
		Route route12 = new Route("route12", subway2);
		
		ProjectMapController controller = ProjectMapController.getInstance();
		
		System.out.println("*** RouteList 생성 ***");
		controller.routeInsert(route1);
		controller.routeInsert(route3);
		controller.routeInsert(route6);
		controller.routeInsert(route7);
		controller.routeInsert(route9);
		controller.routeInsert(route12);
		
		System.out.println("\n\n\n\n*** TransportationList 생성 ***");
		controller.transportationInsert(bus1);
		controller.transportationInsert(bus2);
		controller.transportationInsert(subway1);
		controller.transportationInsert(subway2);
		
		System.out.println("\n\n\n\n*** 모든 Route 검색 ***");
		System.out.println();
		controller.getRouteList();
		
		System.out.println("\n\n\n\n*** route6 검색 ***");
		System.out.println();
		controller.getRoute("route6");
		
		System.out.println("\n\n\n\n*** route6의 AB 구간 교통수단을 subway2(6호선)로 변경 후 검색 ***");
		System.out.println();
		controller.routeABUpdate("route6", subway2);
		
		System.out.println("\n\n\n\n*** route12의 AB 구간 교통수단을 subway2로 변경 후 검색 ***");
		System.out.println();
		controller.routeABUpdate("route12", subway2);
		
		System.out.println("\n\n\n\n*** bus2(동작 03)의 AB 구간 요금을 1100원으로 변경 후 검색 ***");
		System.out.println();
		controller.priceABUpdate("동작 03", 1100);
		controller.getRoute("route6");
		
		System.out.println("\n\n\n\n*** route7 삭제 ***");
		System.out.println();
		controller.routeDelete("route7");
		
		System.out.println("\n\n\n\n*** route7 검색 ***");
		System.out.println();
		controller.getRoute("route7");
		
	}
}
