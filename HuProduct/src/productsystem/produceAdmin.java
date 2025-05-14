package productsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class produceAdmin {

	private productDAO productdao = productDAO.getInstance();

	produceAdmin() {
		Scanner in = new Scanner(System.in);
		boolean f = true;
		while (f) {
			System.out.println("1.등록 2.조회 3.수정 4.삭제 5.제품명 연관 검색//나머지는 종료");
			String selectmenu = in.nextLine();
			switch (selectmenu) {
			case "1":
				add();
				break;
			case "2":
				allList();
				break;
			case "3":
				update();
				break;
			case "4":
				delete();
				break;
			case "5":
				relatedsearch();
				break;
			default:
				System.out.println("종료합니다");
				f = false;
				break;

			}
		}
	}

	private void relatedsearch() {
		Scanner in = new Scanner(System.in);
		System.out.println("검색할 상품명을 쓰시오");
		String proname = in.nextLine();
		
		
		productdao.relatedsearch(proname);
		
	}

	private void add() {
		 Scanner in = new Scanner(System.in);
	        System.out.println("제품명을 쓰시오");
	        String proname = in.nextLine();
	        System.out.println("제품의 설명을 쓰시오");
	        String text = in.nextLine();
	        System.out.println("제품의 수량을 쓰시오");
	        int pronum = in.nextInt();
	        in.nextLine();  // 버퍼 비우기
	        System.out.println("제품의 가격을 쓰시오");
	        int proprice = in.nextInt();
	        in.nextLine();  // 버퍼 비우기
	        System.out.println("담당자를 쓰시오");
	        String manager = in.nextLine();
	        System.out.println("타입id를 쓰시오 (a, b, c, d 중 하나)");
	        String typeid1 = in.nextLine();

	        productDTO productdtoadd = new productDTO();
	        productdtoadd.setProname(proname);
	        productdtoadd.setText(text);
	        productdtoadd.setPronum(pronum);
	        productdtoadd.setProprice(proprice);
	        productdtoadd.setManager(manager);
	        productdtoadd.setTypeid1(typeid1);

	        productdao.insert(productdtoadd);

	}

	private void allList() {
		ArrayList<productDTO> p = productdao.selectAll();
		for (productDTO pp : p) {
			pp.prt();
		}
	}

	private void delete() {
		Scanner in = new Scanner(System.in);
		System.out.println("삭제할 제품명을 쓰시오");
		String deletename = in.nextLine();
		
		productdao.delete(deletename);
		

	}

	private void update() {
        Scanner in = new Scanner(System.in);
        System.out.println("제품명으로 수정을 하시오 제품명을 쓰시오");
        String proname = in.nextLine();
        System.out.println("수정할 제품설명을 쓰시오");
        String text = in.nextLine();
        System.out.println("수정할 수량을 쓰시오");
        int pronum = in.nextInt();
        in.nextLine();
        System.out.println("수정할 가격을 쓰시오");
        int proprice = in.nextInt();
        in.nextLine();
        System.out.println("수정할 담당자를 쓰시오");
        String manager = in.nextLine();
        System.out.println("수정할 타입id를 쓰시오 (a, b, c, d 중 하나)");
        String typeid1 = in.nextLine();
        
        productDTO productdto = new productDTO();
        
        productdto.setProname(proname);
        productdto.setText(text);
        productdto.setPronum(pronum);
        productdto.setProprice(proprice);
        productdto.setManager(manager);
        productdto.setTypeid1(typeid1);
        
        productdao.update(productdto);
        
        
        
	}

	private void selectall() {

	}

}
