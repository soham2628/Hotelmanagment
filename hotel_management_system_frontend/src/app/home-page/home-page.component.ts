import { Component, NgModule, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Hotel } from '../hotel';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { ViewChild } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit{
  hotels:any=[];
  hotel:any;
  userId: any;
  hotelId: any;
  price:any;
  filteredData:any;
  searchField="";
  dataSource: MatTableDataSource<any>;

  // Paginator
  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;


  // Pagination settings
  pageSize = 10;
  pageSizeOptions: number[] = [5, 10, 25, 100];




  constructor(private hotelService:HotelService,private route:Router,private activatedRoute:ActivatedRoute) {
    this.dataSource = new MatTableDataSource<any>(this.filteredData);
  }
  applyFilter(filterValue: string) {
    this.hotels.filter = filterValue.trim().toLowerCase();
  }
  ngAfterViewInit() {
    // Set the paginator after the view initialization
    this.dataSource.paginator = this.paginator;

  }
  ngOnInit(): void {
    this.userId=this.activatedRoute.snapshot.paramMap.get("userId");
    console.log(this.userId);
    this.getHotelList();
  }
  // Example method to retrieve paginated data
  retrievePaginatedData(event: any) {
    const pageIndex = event.pageIndex;
    const pageSize = event.pageSize;
    const startIndex = pageIndex * pageSize;
    const endIndex = startIndex + pageSize;

    const paginatedData = this.dataSource.data.slice(startIndex, endIndex);
    console.log(paginatedData);
    this.filteredData= paginatedData;
  }

  getHotelList()
  {
    this.hotelService.getHotelList().subscribe(data => {this.hotels = data;
      this.filteredData=this.hotels;
      this.dataSource = new MatTableDataSource<any>(this.filteredData);
      this.dataSource.paginator = this.paginator;
     this.filteredData= this.dataSource.filteredData;
  });
  }
  searchbar(){
    this.filteredData=this.hotels.filter((hotel:any)=>{
      if(hotel.hotelName.toLowerCase().includes(this.searchField.toLowerCase())){
        return hotel;
      }
      return null;
    });
  }
  userProfile()
  {
    console.log(this.userId)
    this.route.navigate(['/userProfile',{userId1:this.userId}])
  }
  logOut()
  {
    this.route.navigate(['/welcomepage'])
  }
  back()
  {
    this.route.navigate(['/welcomepage'])
  }
  reservationDetails ()
  {
    this.route.navigate(['/viewReservations',{userId:this.userId}])
  }
  contactUs()
  {
    this.route.navigate(['/contactUs'])
  }
  bookReservation(hotelId:number,price:number){
    //this.price=price;
    console.log(price);
    //this.route.navigate(['/createReservation',{hotelId1:hotelId},{userId:this.userId}]);
    this.route.navigate(["/createReservation",hotelId,price,this.userId]);
  }
}

