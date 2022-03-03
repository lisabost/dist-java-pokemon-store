package edu.wctc.shopping.controller;

import edu.wctc.shopping.entity.Product;
import edu.wctc.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private ProductService productService;

    @Autowired
    public HomeController(ProductService prs) {
        this.productService = prs;
    }

    @RequestMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("pageTitle", "The Pokemon Store");
        return "index";
    }

    @RequestMapping("/list")
    public String showProductList(Model model) {
        model.addAttribute("pageTitle", "Pokemon for Sale");
        model.addAttribute("productList", productService.getProducts());

        return "pokemon-list";
    }

    @RequestMapping("/confirmation")
    public String makePurchase(Model model, @RequestParam("id") int productId) {

        Product p = productService.getProduct(productId);
        if (p.getQuantity() != 0) {
            int tempQty = p.getQuantity() - 1;
            p.setQuantity(tempQty);

            productService.updateProduct(p);

            model.addAttribute("pageTitle", "Thank you for your purchase");
            model.addAttribute("product", productService.getProduct(p.getId()));

            return "confirmation";
        }
        model.addAttribute("pageTitle", "Out Of Stock");
        model.addAttribute("product", productService.getProduct(p.getId()));
        return "out-of-stock";
    }

}
