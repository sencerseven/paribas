import { Component, OnInit } from '@angular/core';
import { PolicyApiService } from 'src/app/services/policy-api.service';
import { ActivatedRoute } from '@angular/router';
import { CustomerOutputModel } from 'src/app/model/customer-output.model';
import { MatTableDataSource } from '@angular/material';
import { CustomerApiService } from 'src/app/services/customer-api.service';

@Component({
  selector: 'app-policy-customers',
  templateUrl: './policy-customers.component.html',
  styleUrls: ['./policy-customers.component.css']
})
export class PolicyCustomersComponent implements OnInit {
  public customers: CustomerOutputModel[] = [];
  dataSource;
  displayedColumns: string[] = ['firstName', 'lastName','birthDate', 'tckNumber', 'address','phoneNumber','action'];
  policyId:number;

  constructor(private policyApiService: PolicyApiService,
    private customerApiService : CustomerApiService,
    private route: ActivatedRoute) {
      customerApiService.newPolicyCustomerAdded.subscribe(data => {
        debugger;
        console.log(data);
        this.customers.push(data);
        this.dataSource= new MatTableDataSource(this.customers);
      });

     }

  ngOnInit() {
    this.policyId = this.route.snapshot.params['id'];
     this.policyApiService.policyCustomers(this.policyId).subscribe(data => {
      this.customers =<CustomerOutputModel[]> data.data;
      console.log(this.customers);
      this.dataSource= new MatTableDataSource(this.customers);
     }) 

  }

  deleteCustomer(id:number){
    this.customerApiService.removeRelation(id,this.policyId).subscribe(data => {
      if(data.code == 200){
        this.customers = this.customers.filter(item => item.id != id);
        this.dataSource= new MatTableDataSource(this.customers);
        alert("Poliçeden Kullanıcı Kaldırıldı");
      }
    })
  }

}
