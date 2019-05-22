import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-nlp-reguly-szczegoly',
  templateUrl: './nlp-reguly-szczegoly.component.html',
  styleUrls: ['./nlp-reguly-szczegoly.component.css']
})
export class NlpRegulySzczegolyComponent implements OnInit {

  constructor(private route: ActivatedRoute) { }
  private sub: any;
  private kod: number;

  ngOnInit() {
     this.sub = this.route.params.subscribe(params => {

            this.kod= +params['kod'];
        });
  }
  getKod(): number {
    return this.kod;
  }
}
