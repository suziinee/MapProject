package view;

import java.util.ArrayList;

import model.dto.Route;

public class EndView {

	//RouteList ���
	public static void routeListView(ArrayList<Route> routeList) {
		
		if (routeList != null) {
			int count = routeList.size();
			for (int i = 0; i < count; i++) {
				if (routeList.get(i) != null) {
					System.out.println(routeList.get(i));
				} 
			}
		}else {
			System.out.println("RouteList�� �����ϴ�.");
		}
	}
	
	//Route ���
	public static void routeView(Route r) {
		
		if (r != null) {
			System.out.println(r);
		}else {
			System.out.println("�ش� Route�� �������� �ʽ��ϴ�.");
		}
	}
	
	//Transportation ���
	public static void transportationView(Object o) {
		
		if (o != null) {
			System.out.println(o);
		}else {
			System.out.println("�ش� ��������� �������� �ʽ��ϴ�.");
		}
	}
	
	//���� �޼��� ���
	public static void successView(String s) {
		System.out.println(s);
	}
	
}
