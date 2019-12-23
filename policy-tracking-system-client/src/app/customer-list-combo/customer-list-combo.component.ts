import { Component, OnInit, Input } from '@angular/core';
import { CustomerOutputModel } from '../model/customer-output.model';
import { CustomerApiService } from '../services/customer-api.service';

@Component({
  selector: 'app-customer-list-combo',
  templateUrl: './customer-list-combo.component.html',
  styleUrls: ['./customer-list-combo.component.css']
})  
export class CustomerListComboComponent implements OnInit {
  @Input() editId:number;
  public customers: CustomerOutputModel[] = [];
  public selected:number;
  constructor(private customerApiService:CustomerApiService) { }

  ngOnInit() {
    this.customerApiService.getAllCustomer(new CustomerOutputModel()).subscribe(data => {
      if(data.code == 200){
   
        this.customers =<CustomerOutputModel[]> data.data;
      }
    });

  }

  public addCustomer(){
    console.log(this.editId);
    this.customerApiService.addRelation(this.selected,this.editId).subscribe(data => {
      debugger;
      if(data.code == 200){
        
        this.customerApiService.newPolicyCustomerAdded.emit(<CustomerOutputModel>data.data);
      }
    });
  }

}
