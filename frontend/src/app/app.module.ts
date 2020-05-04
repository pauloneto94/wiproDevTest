import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule }    from '@angular/common/http';
import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';
import { NewProductComponent } from './new-product/new-product.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { InactiveProductsComponent } from './inactive-products/inactive-products.component';
import { FormsModule } from '@angular/forms';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { AuthGuard } from './auth/auth.guard';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    NewProductComponent,
    LoginComponent,
    InactiveProductsComponent,
    ProductDetailComponent,
    SearchBarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
