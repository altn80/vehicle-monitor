import { Component, OnInit, OnChanges, SimpleChanges, Input } from '@angular/core';
import { Customer } from '../customers/customer';
import { Vehicle } from './vehicle';
import { VehicleService } from '../vehicle.service';
import {interval} from "rxjs/internal/observable/interval";
import {startWith, switchMap} from "rxjs/operators"

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnChanges {

  @Input() customer: Customer;
  @Input() status: string;

  vehicles: Vehicle[];

  constructor(private vehicleService: VehicleService) { }

  ngOnChanges() {
    this.getVehicles();
  }

  getVehicles(): void {
    interval(5000)
    .pipe(
      startWith(0),
      switchMap(() => this.vehicleService.getVehicles(this.customer.id, this.status)))
      .subscribe(vehicles => this.vehicles = vehicles);
  }
}
