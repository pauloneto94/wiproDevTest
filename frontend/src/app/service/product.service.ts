import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../model/products';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  serverUrl: string = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getActiveProducts(){
    return this.http.get<Product[]>(this.serverUrl+'/activateProducts');
  }

  getInactiveProducts(){
    return this.http.get<Product[]>(this.serverUrl+'/inactivateProducts');
  }

  getProduct(code: string){
    return this.http.get<Product>(this.serverUrl+'/products/'+code);
  }

  addProduct(product: Product){
    return this.http.post<Product>(this.serverUrl+'/products', product).subscribe(respose =>{
      console.log(respose);
    }, err =>{
      console.log(err);
      alert("Produto ja cadastrado!");
    });
  }

  updateProduct(product: Product){
    return this.http.patch<Product>(this.serverUrl+'/products/'+product.code, product).subscribe();
  }

  inativateProduct(code: string) {
    return this.http.get<Product>(this.serverUrl+'/inactivate/'+code, {observe: 'response'}).subscribe(respose =>{
      console.log(respose);
    }, err =>{
      console.log(err);
      alert("Produto ja inválido!");
    });
  }

}
