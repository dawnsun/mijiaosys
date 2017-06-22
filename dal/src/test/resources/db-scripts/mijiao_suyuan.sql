/*==============================================================*/
/* 大半夜的 突然好喜欢蓝天白云和我的梦想                        */
/*==============================================================*/

/*==============================================================*/
/* Table: LAND_RES                                              */
/*==============================================================*/
create table LAND_RES
(
   id                   bigint(20) unsigned not null auto_increment,
   longitude            varchar(16)  comment '经度',
   latitude             varchar(16)  comment '纬度',
   altitude             varchar(16)  comment '海拔',
   alias                varchar(32)  comment '土地别名',
   address              varchar(128)  comment '土地详细地址',
   size                 varchar(16)  comment '面积大小',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table LAND_RES comment '土地资源表';

/*==============================================================*/
/* Table: CROPS                                              */
/*==============================================================*/
create table CROPS
(
   id                   bigint(20) unsigned not null auto_increment,
   crops_name            varchar(64) not null comment '农作物名称',
   crops_icon            varchar(32) not null comment '农作物图标',
   parent_id            bigint(20) unsigned not null comment '父农作物ID',
   crops_order           int(10) not null comment '农作物排序',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table CROPS comment '农作物表';

/*==============================================================*/
/* Table: TESTING_INSTITUTION                                              */
/*==============================================================*/
create table TESTING_INSTITUTION
(
   id                   bigint(20) unsigned not null auto_increment,
   institution_name            varchar(64) not null comment '检测机构名称',
   institution_address         varchar(32) not null comment '检测机构地址',
   institution_contacts        varchar(32) not null comment '检测机构联系人',
   institution_phone           varchar(16) not null comment '检测机构电话',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table TESTING_INSTITUTION comment '检测机构表';

/*==============================================================*/
/* Table: LAND_QUALITY                                          */
/*==============================================================*/
create table LAND_QUALITY
(
   id                   bigint(20) unsigned not null auto_increment,
   land_id              bigint(20) unsigned not null comment '土地资源主键',
   over_elements        varchar(16)  comment '超标元素',
   missing_elements     varchar(16)  comment '缺失元素',
   ph                varchar(2)  comment '酸碱度',
   testing_id              varchar(128)  comment '检测机构id',
   gmt_testing           datetime not null comment '监测时间',
   testing_file                 varchar(16)  comment '检测附件',
   land_img                 varchar(16)  comment '当前土地照片附件id多张用逗号隔开',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table LAND_QUALITY comment '土地质量监测表';


/*==============================================================*/
/* Table: QUARTER_LAND_CROPS                                    */
/*==============================================================*/
create table QUARTER_LAND_CROPS
(
   id                   bigint(20) unsigned not null auto_increment,
   year              varchar(8) comment '年份',
   quarter        varchar(16)  comment '季度份',
   land_id     bigint(20) unsigned not null comment '土地id',
   user_id     bigint(20) unsigned not null  comment '管理者id',
   crops_id     bigint(20) unsigned not null comment '作物id',
   crops_no           varchar(16) comment '作物数量',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table QUARTER_LAND_CROPS comment '季度土地作物表';

/*==============================================================*/
/* Table: PHENOLOGICAL_PHASE                                    */
/*==============================================================*/
create table QUARTER_LAND_CROPS
(
   id                   bigint(20) unsigned not null auto_increment,
   phenological_name              varchar(256) comment '物候名称',
   crops_id     bigint(20) unsigned not null comment '作物id',
   start_month_day         varchar(32)  comment '开始时间',
   end_month_day          varchar(32)  comment '结束时间',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table PHENOLOGICAL_PHASE comment '物候期表';


/*==============================================================*/
/* Table: CROPS_OPERATION                                    */
/*==============================================================*/
create table CROPS_OPERATION
(
   id                   bigint(20) unsigned not null auto_increment,
   operation_name              varchar(256) comment '操作名称',
   crops_id     bigint(20) unsigned not null comment '作物id',
   is_main_operation     tinyint(1) not null DEFAULT '0' comment '是否重点操作 0-否 1-是',
   main_option_table      varchar(256)  comment '重点操作关联表名（农药喷洒，施肥）',
   operation_order           int(10) not null comment '操作排序',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table CROPS_OPERATION comment '作物操作配置表';


/*==============================================================*/
/* Table: DAILY_OPERATION                                    */
/*==============================================================*/
create table DAILY_OPERATION
(
   id                   bigint(20) unsigned not null auto_increment,
   land_id     bigint(20) unsigned not null comment '土地id',
   crops_id     bigint(20) unsigned not null comment '作物id',
   user_id     bigint(20) unsigned not null  comment '管理者id',
   operation_id     bigint(20) unsigned not null comment '操作id',
   is_pests     tinyint(1) not null DEFAULT '0' comment '是否发现病虫害 0-无 1-有',
   operation_photo    varchar(1024) comment '操作照片',
   pests_remarks     varchar(1024)  comment '病虫害备注',
   operation_remarks     varchar(1024)  comment '操作备注',
   extended           varchar(2000)  comment '扩展字段，key-velue存储扩展操作（农药，施肥等重点操作）',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '修改时间',
   creator              varchar(32) not null comment '创建人',
   modifier             varchar(32) not null comment '修改人',
   is_delete            tinyint(1) not null  DEFAULT '0' comment '0-有效 1-删除',
   primary key (id)
);

alter table DAILY_OPERATION comment '日常作物操作表';




作物产值表

上市作物规格表

作物行情表

农资模块设计

仓储物流溯源模块设计

作物交易设计

农资交易设计

财务模块设计


