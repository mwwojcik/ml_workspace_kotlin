import * as tslib_1 from "tslib";
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { LoginModule } from './login/login.module';
import { DashboardModule } from './dashboard/dashboard.module';
import { RegistrationModule } from './registration/registration.module';
import { LayoutModule } from './layout/layout.module';
import { UsersModule } from './users/users.module';
import { AccountSettingsModule } from './account-settings/account-settings.module';
var routes = [
    {
        path: '',
        redirectTo: '/dashboard',
        pathMatch: 'full'
    }
];
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib_1.__decorate([
        NgModule({
            declarations: [
                AppComponent
            ],
            imports: [
                BrowserModule,
                RouterModule.forRoot(routes),
                LayoutModule,
                LoginModule,
                DashboardModule,
                RegistrationModule,
                UsersModule,
                AccountSettingsModule
            ],
            providers: [],
            bootstrap: [AppComponent]
        })
    ], AppModule);
    return AppModule;
}());
export { AppModule };
//# sourceMappingURL=app.module.js.map