import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MainLayoutComponent } from '../layout/main-layout/main-layout.component';
import { UsersComponent } from './users.component';
var routes = [
    {
        path: 'users',
        component: MainLayoutComponent,
        children: [
            { path: '', component: UsersComponent }
        ]
    }
];
var UsersRoutingModule = /** @class */ (function () {
    function UsersRoutingModule() {
    }
    UsersRoutingModule = tslib_1.__decorate([
        NgModule({
            imports: [RouterModule.forChild(routes)],
            exports: [RouterModule]
        })
    ], UsersRoutingModule);
    return UsersRoutingModule;
}());
export { UsersRoutingModule };
//# sourceMappingURL=users-routing.module.js.map