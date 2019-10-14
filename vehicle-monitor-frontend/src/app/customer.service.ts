import { Injectable } from '@angular/core';
import { Customer } from './customers/customer';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private customersUrl = 'http://localhost:8080/customers/';

  constructor(private http: HttpClient) { }

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.customersUrl);
  }

  getCustomersById(idCustomer: number): Observable<Customer> {
    return this.http.get<Customer>(this.customersUrl + idCustomer);
  }
}
