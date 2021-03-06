import { AdminGuard } from '../core/admin/admin.guard';
import { AdminComponent } from './admin/admin.component';
import { PrivateGuard } from '../core/template/private/private.guard';
import { PrivateComponent } from '../core/template/private/private.component';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

const PRIVATE_ROUTES: Routes = [
  { path: 'admin', component: AdminComponent, canActivate: [AdminGuard] }
];

const SNIPPETS_ROUTES: Routes = [
  { path: '', component: PrivateComponent, children: PRIVATE_ROUTES, canActivate: [PrivateGuard] }
];

@NgModule({
  imports: [
    RouterModule.forChild(SNIPPETS_ROUTES)
  ],
  exports: [
    RouterModule
  ]
})
export class UserRoutingModule { }
