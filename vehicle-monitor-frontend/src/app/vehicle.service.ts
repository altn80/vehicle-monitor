import { Injectable } from '@angular/core';
import { Vehicle } from './vehicles/vehicle';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  private vehiclesUrl = 'http://localhost:8080/vehicles/';

  constructor(private http: HttpClient) { }

  getVehicles(idCustomer: number, status: string): Observable<Vehicle[]> {
    if (status == "0") {
      return this.http.get<Vehicle[]>(this.vehiclesUrl + idCustomer);
    } else {
      return this.http.get<Vehicle[]>(this.vehiclesUrl + idCustomer + "/" + status);
    }
  }
}
