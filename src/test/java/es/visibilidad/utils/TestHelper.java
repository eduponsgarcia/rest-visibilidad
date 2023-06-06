package es.visibilidad.utils;

import java.util.ArrayList;
import java.util.List;


import es.visibilidad.entity.Product;
import es.visibilidad.entity.Size;
import es.visibilidad.entity.Stock;

public class TestHelper {
	
	/* 
	 * Clase para creacion de entidades ficticas para la realizacion 
	 * de los tests que comprueben los métodos
	 */
	
	
	public static List<Stock> buildStock() {
		
		List<Stock> stock=new ArrayList<>();
		stock.add(Stock.builder().quantity(0).size(Size.builder().id(11).special(false).backSoon(true).product(Product.builder().id(1).sequence(10).build()).build()).build());
		stock.add(Stock.builder().quantity(0).size(Size.builder().id(12).special(false).backSoon(false).product(Product.builder().id(1).sequence(10).build()).build()).build());
		stock.add(Stock.builder().quantity(0).size(Size.builder().id(13).special(false).backSoon(true).product(Product.builder().id(1).sequence(10).build()).build()).build());
		stock.add(Stock.builder().quantity(0).size(Size.builder().id(22).special(false).backSoon(false).product(Product.builder().id(2).sequence(7).build()).build()).build());
		stock.add(Stock.builder().quantity(10).size(Size.builder().id(31).special(false).backSoon(true).product(Product.builder().id(3).sequence(15).build()).build()).build());
		stock.add(Stock.builder().quantity(10).size(Size.builder().id(32).special(false).backSoon(true).product(Product.builder().id(3).sequence(15).build()).build()).build());
		stock.add(Stock.builder().quantity(10).size(Size.builder().id(33).special(false).backSoon(false).product(Product.builder().id(3).sequence(15).build()).build()).build());
		stock.add(Stock.builder().quantity(0).size(Size.builder().id(41).special(false).backSoon(false).product(Product.builder().id(4).sequence(13).build()).build()).build());
		stock.add(Stock.builder().quantity(0).size(Size.builder().id(42).special(false).backSoon(false).product(Product.builder().id(4).sequence(13).build()).build()).build());
		stock.add(Stock.builder().quantity(0).size(Size.builder().id(43).special(false).backSoon(false).product(Product.builder().id(4).sequence(13).build()).build()).build());
		stock.add(Stock.builder().quantity(10).size(Size.builder().id(44).special(true).backSoon(true).product(Product.builder().id(4).sequence(13).build()).build()).build());
		stock.add(Stock.builder().quantity(10).size(Size.builder().id(51).special(true).backSoon(true).product(Product.builder().id(5).sequence(6).build()).build()).build());
		stock.add(Stock.builder().quantity(10).size(Size.builder().id(52).special(false).backSoon(false).product(Product.builder().id(5).sequence(6).build()).build()).build());
		stock.add(Stock.builder().quantity(10).size(Size.builder().id(53).special(false).backSoon(false).product(Product.builder().id(5).sequence(6).build()).build()).build());
		stock.add(Stock.builder().quantity(10).size(Size.builder().id(54).special(true).backSoon(true).product(Product.builder().id(5).sequence(6).build()).build()).build());
        return stock;
    }

}
