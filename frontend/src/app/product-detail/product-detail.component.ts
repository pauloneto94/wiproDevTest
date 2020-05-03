import { OnInit, Component } from '@angular/core';
import { ProductService } from '../service/product.service';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../model/products';
import { Location } from '@angular/common';


@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  constructor(private productService: ProductService,
    private route: ActivatedRoute,
    private location: Location) { }

  product: Product;

  ngOnInit(): void {
    this.getProduct();
  }

  getProduct() {
    const id = this.route.snapshot.paramMap.get('id');
    this.productService.getProduct(id).subscribe(product =>{
      this.product = product;
    });
  }

  onSubmit(){
    this.productService.updateProduct(this.product);
  }

  goBack(): void {
    this.location.back();
  }

  get diagnostic() { return JSON.stringify(this.product); }

}
