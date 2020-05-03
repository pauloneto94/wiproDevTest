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
    return this.http.get<Product[]>('http://localhost:8080/activateProducts');
  }

  getInactiveProducts(){
    return this.http.get<Product[]>(this.serverUrl+'/inactivateProducts');
  }

  getProduct(code: string){
    return this.http.get<Product>(this.serverUrl+'/products/${code}');
  }

  addProduct(product: Product){
    return this.http.post<Product>(this.serverUrl+'/products', product);
  }

}
