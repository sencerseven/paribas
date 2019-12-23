import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Params,Router} from '@angular/router'; 
import { CustomerApiService } from 'src/app/services/customer-api.service';
import { CustomerOutputModel } from 'src/app/model/customer-output.model';
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import {first} from "rxjs/operators";
import { MatNativeDateModule } from '@angular/material';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  customer:CustomerOutputModel;
  editForm: FormGroup;
  

  constructor(private formBuilder: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
      private customerApiService: CustomerApiService) { }




  ngOnInit() {
    this.editForm = this.formBuilder.group({
      id: [''],
      tckNumber: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      birthDate: [''],
      address: ['', Validators.required],
      phoneNumber: ['', Validators.required]
    });


   var id = this.route.snapshot.params['id'];
   this.customer  = new CustomerOutputModel();
   this.customer.id = id;
    this.customerApiService.getAllCustomer(this.customer).subscribe(data => {
      if(data.code == 200){
        this.customer = <CustomerOutputModel>data.data;
        console.log(this.customer);
        this.editForm.setValue(this.customer[0]);
        
      }
    });

  }

  onSubmit() {
    this.customerApiService.saveUser(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          if(data.code == 200) {
            alert('User updated successfully.');
            this.router.navigate(['customer']);
          }else {

          }
        },
        error => {
          alert(error);
        });
  }
}
