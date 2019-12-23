import { Component, OnInit } from '@angular/core';
import {CustomerApiService } from '../../services/customer-api.service';
import { CustomerOutputModel } from 'src/app/model/customer-output.model';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
 public customers: CustomerOutputModel[] = [];
 dataSource;
  displayedColumns: string[] = ['firstName', 'lastName','birthDate', 'tckNumber', 'address','phoneNumber','action'];
 

  constructor(private customerApiService: CustomerApiService) { 
   customerApiService.newCustomerAdded.subscribe( data => {
     console.log("gelen var");
     console.log(data);
     this.customers.push(data);
     this.dataSource = new MatTableDataSource(this.customers);
   });
  }

  ngOnInit() {
    this.customerApiService.getAllCustomer(new CustomerOutputModel()).subscribe(data => {
      if(data.code == 200){
   
        this.customers =<CustomerOutputModel[]> data.data;
        console.log(this.dataSource);
        this.dataSource= new MatTableDataSource(this.customers);
      }
    });

  };

  deleteCustomer(id:number){
    this.customerApiService.deleteUser(id).subscribe(data => {
      if(data.code == 200){

     this.customers = this.customers.filter(item => item.id != id);
     this.dataSource = new MatTableDataSource(this.customers);

        alert("Başarıyla Silindi");
      }else{
        alert("Silinemedi");
      }
    });
  }

}
