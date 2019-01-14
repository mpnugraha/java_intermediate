package com.java.test.intermediate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.test.intermediate.dao.OrderDao;
import com.java.test.intermediate.model.Order;
import com.java.test.intermediate.model.OrderDetail;

@Controller
public class OrderController {
	
	@Autowired
    private OrderDao orderDao;
	    
    @RequestMapping("/orders")
    public String orders(Model model) {
        System.out.println("Display all orders...");
        List<Integer> listId = orderDao.findId();
        List<Order> list = orderDao.findById(listId.get(0));        
        List<OrderDetail> listOrderDetail = orderDao.findOrderDetailByOrderId(listId.get(0));
        int nextId = listId.size()>1?listId.get(1):listId.get(0);
        int firstId = listId.get(0);
        int lastId = listId.get(listId.size()-1);
        double orderSubTotal = orderDao.countOrderSubtotal(listId.get(0));
        double orderTotal = orderDao.countOrderTotal(listId.get(0));
        model.addAttribute("list", list);
        model.addAttribute("listOrderDetail", listOrderDetail);
        model.addAttribute("firstId", firstId);
        model.addAttribute("nextId", nextId);
        model.addAttribute("prevId", listId.get(0));
        model.addAttribute("lastId", lastId);
        model.addAttribute("orderSubTotal",orderSubTotal);
        model.addAttribute("orderTotal",orderTotal);
        return "orders"; 
    }
    
    @RequestMapping(value = "/orders/{id}", method=RequestMethod.GET)
    public String listNotes(@PathVariable("id")int id,Model model) {
    	List<Order> list = orderDao.findById(id);
        List<Integer> listId = orderDao.findId();
        List<OrderDetail> listOrderDetail = orderDao.findOrderDetailByOrderId(id);
        int nextId = listId.indexOf(id)<listId.size()-1?listId.get(listId.indexOf(id)+1):listId.get(listId.indexOf(id));
        int prevId = listId.indexOf(id)>0?listId.get(listId.indexOf(id)-1):listId.get(listId.indexOf(id));
        int firstId = listId.get(0);
        int lastId = listId.get(listId.size()-1);
        double orderSubTotal = orderDao.countOrderSubtotal(id);
        double orderTotal = orderDao.countOrderTotal(id);
        model.addAttribute("list", list);
        model.addAttribute("listOrderDetail", listOrderDetail);
        model.addAttribute("firstId", firstId);
        model.addAttribute("nextId", nextId);
        model.addAttribute("prevId", prevId);
        model.addAttribute("lastId", lastId);
        model.addAttribute("orderSubTotal",orderSubTotal);
        model.addAttribute("orderTotal",orderTotal);
        return "orders"; 
    }
}
