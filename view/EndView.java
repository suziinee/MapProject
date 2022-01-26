package view;

import java.util.ArrayList;
import java.util.Optional;

import model.dto.Route;

public class EndView {

	
	/* RouteList 출력 */
	public static void routeListView(ArrayList<Route> routeList) {
		
		Optional<ArrayList<Route>> opt = Optional.ofNullable(routeList);
		
		opt.ifPresentOrElse(data -> {
			data.stream().forEach(System.out::println);
		}, () -> {
			System.out.println("RouteList가 없습니다.");
		});
	}
	
	


	/* Route 출력 */
	public static void routeView(Route r) {
		Optional<Route> opt = Optional.ofNullable(r);
		
		opt.ifPresentOrElse(data -> {
			System.out.println(data);
		}, () -> {
			System.out.println("해당 Route는 존재하지 않습니다.");
		});
	}
	
	
	

	/* Transportation 출력 */
	public static void transportationView(Object o) {
		Optional<Object> opt = Optional.ofNullable(o);
		
		opt.ifPresentOrElse(data -> {
			System.out.println(o);
		}, () -> {
			System.out.println("해당 교통수단은 존재하지 않습니다.");
		});
	}
	
	
	

	/* 성공 메세지 출력 */
	public static void successView(String s) {
		System.out.println(s);
	}
	
}
