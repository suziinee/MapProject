package view;

import java.util.ArrayList;

import model.dto.Route;

public class EndView {

	//RouteList 출력
	public static void routeListView(ArrayList<Route> routeList) {
		
		if (routeList != null) {
			int count = routeList.size();
			for (int i = 0; i < count; i++) {
				if (routeList.get(i) != null) {
					System.out.println(routeList.get(i));
				} 
			}
		}else {
			System.out.println("RouteList가 없습니다.");
		}
	}
	
	//Route 출력
	public static void routeView(Route r) {
		
		if (r != null) {
			System.out.println(r);
		}else {
			System.out.println("해당 Route는 존재하지 않습니다.");
		}
	}
	
	//Transportation 출력
	public static void transportationView(Object o) {
		
		if (o != null) {
			System.out.println(o);
		}else {
			System.out.println("해당 교통수단은 존재하지 않습니다.");
		}
	}
	
	//성공 메세지 출력
	public static void successView(String s) {
		System.out.println(s);
	}
	
}
