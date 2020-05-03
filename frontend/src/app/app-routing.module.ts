import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductsComponent } from './products/products.component';
import { InactiveProductsComponent } from './inactive-products/inactive-products.component';

const routes: Routes = [
  { path: 'products', component: ProductsComponent },
  { path: 'Inactiveproducts', component: InactiveProductsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }