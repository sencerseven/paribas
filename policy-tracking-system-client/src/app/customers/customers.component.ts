import { Component, OnInit } from '@angular/core';
import { CustomerOutputModel } from '../model/customer-output.model';
import {CustomerApiService } from '../services/customer-api.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {
  newCustomer: CustomerOutputModel;


  constructor(private customerApiService: CustomerApiService) { }

  ngOnInit() {
   
  }


}
