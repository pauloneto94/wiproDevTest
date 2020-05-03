import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductsComponent } from './products/products.component';
import { InactiveProductsComponent } from './inactive-products/inactive-products.component';
import { NewProductComponent } from './new-product/new-product.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { SearchBarComponent } from './search-bar/search-bar.component';

const routes: Routes = [
  { path: 'products', component: ProductsComponent },
  { path: 'Inactiveproducts', component: InactiveProductsComponent },
  { path: 'newProduct', component: NewProductComponent },
  { path: 'product/:id', component: ProductDetailComponent },
  { path: 'search', component: SearchBarComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }