import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { Routes, RouterModule} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import {ReactiveFormsModule} from "@angular/forms";

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CustomersComponent } from './customers/customers.component';
import { PolicyComponent } from './policy/policy.component';
import { PolicyRegisterComponent } from './policy/policy-register/policy-register.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { CustomerApiService } from './services/customer-api.service';
import { CustomerListComponent } from './customers/customer-list/customer-list.component';

import { EditCustomerComponent } from './customers/edit-customer/edit-customer.component';

import { MatSelectModule,MatInputModule, MatFormFieldModule ,MatDatepickerModule, MatNativeDateModule, MatTableModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PolicyApiService } from './services/policy-api.service';
import { PolicyListComponent } from './policy/policy-list/policy-list.component';
import { PolicyEditComponent } from './policy/policy-edit/policy-edit.component';
import { CustomerListComboComponent } from './customer-list-combo/customer-list-combo.component';
import { PolicyCustomersComponent } from './policy/policy-customers/policy-customers.component';
import { HomeComponent } from './home/home.component';
const appRoutes: Routes = [
   {path: '', component: HomeComponent},
   {path: 'customer', component: CustomersComponent},
   {path: 'customer/edit/:id' , component: EditCustomerComponent},
   {path: 'policy', component: PolicyComponent},
   {path: 'policy/edit/:id', component: PolicyEditComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CustomersComponent,
    PolicyComponent,
    UserRegisterComponent,
    CustomerListComponent,
    EditCustomerComponent,
    PolicyRegisterComponent,
    PolicyListComponent,
    PolicyEditComponent,
    CustomerListComboComponent,
    PolicyCustomersComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    MatTableModule,
    ReactiveFormsModule,
    MatDatepickerModule,        // <----- import(must)
    MatNativeDateModule, 
    MatFormFieldModule ,  
    MatInputModule,
    MatSelectModule,
    BrowserAnimationsModule
    
  ],
  providers: [CustomerApiService,PolicyApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
