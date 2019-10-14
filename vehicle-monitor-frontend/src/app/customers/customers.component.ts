import { Component, OnInit } from '@angular/core';
import { Customer } from "./customer"
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  customers: Customer[];
  customersFilter: Customer[];
  status: string = "0";

  constructor(private customerService: CustomerService) {
    this.customerService.getCustomers()
      .subscribe(customers => this.customersFilter = customers);

  }

  ngOnInit() {
    this.getCustomers();
  }

  filterCustomers(filterVal: number) {
    this.customers = [];
    if (filterVal == 0)
      this.getCustomers();
    else
      this.getCustomersById(filterVal);
  }

  updateStatus(status: string) {
    this.status = status;
  }

  getCustomers(): void {
    this.customerService.getCustomers()
      .subscribe(customers => this.customers = customers);
  }

  getCustomersById(idCustomer: number): void {
    this.customerService.getCustomersById(idCustomer)
      .subscribe(customer => this.customers.push(customer));
  }

}
