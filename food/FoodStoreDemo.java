package food;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import mgr.Factory;
import mgr.Manager;

//Jframe 생성 후 이 FoodStoreDemo 클래스로 넘어와 프로그램이 돌아감
public class FoodStoreDemo extends JPanel {
    private static final long serialVersionUID = 1L;
    JTable table = null;
    
    public Manager<KorFood> korFoodMgr = new Manager<>();
	public Manager<DessertFood> dessertFoodMgr = new Manager<>();
	public Manager<WesternFood> westernFoodMgr = new Manager<>();
	
    public FoodStoreDemo() {
    	foodTableInit();
    }
    
    void foodTableInit() {
    	// 각 Manager마다 txt 파일을 읽는 부분
    	korFoodMgr.readAll("KorFood.txt", new Factory<KorFood>() {
			@Override
			public KorFood create() {
				return new KorFood();
			}
		});
		westernFoodMgr.readAll("WesternFood.txt", new Factory<WesternFood>() {
			@Override
			public WesternFood create() {
				return new WesternFood();
			}
		});
		dessertFoodMgr.readAll("DessertFood.txt", new Factory<DessertFood>() {
			@Override
			public DessertFood create() {
				return new DessertFood();
			}
		});
		
		// table의 맨 위에 위치하는 분류 항목들
        // tablemodel를 통해 table 데이터의 큰 틀을 짜준다
        final String[] columnNames = {"메인/사이드/후식", "맛", "재료", "타입", "이름"}; 
    	DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); 
    	for (KorFood f : korFoodMgr.mList) // addRow함수로 행 추가
    		tableModel.addRow(f.getTexts());
    	for (WesternFood f : westernFoodMgr.mList)
    		tableModel.addRow(f.getTexts());
    	for (DessertFood f : dessertFoodMgr.mList)
    		tableModel.addRow(f.getTexts());
       	table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 220));
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table); // 스크롤 기능 생성 및 추가
        add(scrollPane);
    }
}
