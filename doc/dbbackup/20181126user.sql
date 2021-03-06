USE [master]
GO
/****** Object:  Database [shrwuserdb]    Script Date: 11/26/2018 12:15:34 ******/
CREATE DATABASE [shrwuserdb] ON  PRIMARY 
( NAME = N'shrwuserdb', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\shrwuserdb.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'shrwuserdb_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\shrwuserdb_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [shrwuserdb] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [shrwuserdb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [shrwuserdb] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [shrwuserdb] SET ANSI_NULLS OFF
GO
ALTER DATABASE [shrwuserdb] SET ANSI_PADDING OFF
GO
ALTER DATABASE [shrwuserdb] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [shrwuserdb] SET ARITHABORT OFF
GO
ALTER DATABASE [shrwuserdb] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [shrwuserdb] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [shrwuserdb] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [shrwuserdb] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [shrwuserdb] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [shrwuserdb] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [shrwuserdb] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [shrwuserdb] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [shrwuserdb] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [shrwuserdb] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [shrwuserdb] SET  DISABLE_BROKER
GO
ALTER DATABASE [shrwuserdb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [shrwuserdb] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [shrwuserdb] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [shrwuserdb] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [shrwuserdb] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [shrwuserdb] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [shrwuserdb] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [shrwuserdb] SET  READ_WRITE
GO
ALTER DATABASE [shrwuserdb] SET RECOVERY SIMPLE
GO
ALTER DATABASE [shrwuserdb] SET  MULTI_USER
GO
ALTER DATABASE [shrwuserdb] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [shrwuserdb] SET DB_CHAINING OFF
GO
USE [shrwuserdb]
GO
/****** Object:  User [root]    Script Date: 11/26/2018 12:15:34 ******/
CREATE USER [root] FOR LOGIN [root] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[user_info]    Script Date: 11/26/2018 12:15:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_info](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[account] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[mobile] [nvarchar](50) NOT NULL,
	[user_name] [nvarchar](50) NOT NULL,
	[user_position] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_user_info_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[user_info] ON
INSERT [dbo].[user_info] ([id], [account], [password], [mobile], [user_name], [user_position]) VALUES (9, N'wuqi', N'123456', N'13588888888', N'吴琪', N'巡检员')
INSERT [dbo].[user_info] ([id], [account], [password], [mobile], [user_name], [user_position]) VALUES (19, N'zhangsan', N'123456', N'13190076505', N'张三', N'巡查员')
INSERT [dbo].[user_info] ([id], [account], [password], [mobile], [user_name], [user_position]) VALUES (20, N'lisi', N'123456', N'13190076505', N'李四', N'巡查员')
INSERT [dbo].[user_info] ([id], [account], [password], [mobile], [user_name], [user_position]) VALUES (21, N'wangwu', N'123456', N'13190076505', N'王五', N'巡查员')
INSERT [dbo].[user_info] ([id], [account], [password], [mobile], [user_name], [user_position]) VALUES (22, N'test', N'123456', N'13190076505', N'测试使用', N'测试员')
INSERT [dbo].[user_info] ([id], [account], [password], [mobile], [user_name], [user_position]) VALUES (23, N'zhujinlong', N'123456', N'13190076505', N'朱金龙', N'巡查员')
INSERT [dbo].[user_info] ([id], [account], [password], [mobile], [user_name], [user_position]) VALUES (24, N'sunyu', N'123456', N'13190076505', N'孙宇', N'巡查员')
INSERT [dbo].[user_info] ([id], [account], [password], [mobile], [user_name], [user_position]) VALUES (25, N'wangerxiao', N'123465', N'13190076505', N'王二小', N'巡查员')
INSERT [dbo].[user_info] ([id], [account], [password], [mobile], [user_name], [user_position]) VALUES (26, N'zhaosi', N'123456', N'13190076505', N'赵四', N'巡查员')
INSERT [dbo].[user_info] ([id], [account], [password], [mobile], [user_name], [user_position]) VALUES (27, N'wangchanggui', N'123456', N'13190076505', N'王长贵', N'村长')
SET IDENTITY_INSERT [dbo].[user_info] OFF
/****** Object:  Table [dbo].[resource]    Script Date: 11/26/2018 12:15:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[resource](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL,
	[icon_class] [varchar](255) NULL,
	[action_link] [varchar](255) NULL,
	[father_id] [int] NULL,
	[menu_flag] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[resource] ON
INSERT [dbo].[resource] ([id], [name], [icon_class], [action_link], [father_id], [menu_flag]) VALUES (1, N'系统首页', N'icon-home', N'admin/index', NULL, N'index')
INSERT [dbo].[resource] ([id], [name], [icon_class], [action_link], [father_id], [menu_flag]) VALUES (3, N'用户管理', N'icon-monitor', N'admin/userInfo', NULL, N'userInfo')
INSERT [dbo].[resource] ([id], [name], [icon_class], [action_link], [father_id], [menu_flag]) VALUES (5, N'巡查记录', N'icon-order', N'admin/patrolList/index', NULL, N'patrolTypeDictionary')
INSERT [dbo].[resource] ([id], [name], [icon_class], [action_link], [father_id], [menu_flag]) VALUES (6, N'巡查轨迹', N'icon-server', N'admin/trackList/index', NULL, N'trackList')
INSERT [dbo].[resource] ([id], [name], [icon_class], [action_link], [father_id], [menu_flag]) VALUES (7, N'巡查类型管理', N'icon-center', N'admin/patrolTypeDictionary/index', NULL, N'patrolList')
INSERT [dbo].[resource] ([id], [name], [icon_class], [action_link], [father_id], [menu_flag]) VALUES (8, N'软件更新', N'icon-message', N'admin/version', NULL, N'versionUpdate')
SET IDENTITY_INSERT [dbo].[resource] OFF
/****** Object:  Table [dbo].[patrol_type_dictionary]    Script Date: 11/26/2018 12:15:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[patrol_type_dictionary](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[patrol_type_dictionary] ON
INSERT [dbo].[patrol_type_dictionary] ([id], [name]) VALUES (9, N'aaaaa')
INSERT [dbo].[patrol_type_dictionary] ([id], [name]) VALUES (10, N'ttttttt')
SET IDENTITY_INSERT [dbo].[patrol_type_dictionary] OFF
/****** Object:  Table [dbo].[patrol_records]    Script Date: 11/26/2018 12:15:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[patrol_records](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[create_time] [datetime] NULL,
	[file_path] [nvarchar](500) NULL,
	[user_id] [int] NULL,
	[explain] [nvarchar](500) NULL,
	[longitude] [decimal](10, 6) NULL,
	[latitude] [decimal](10, 6) NULL,
	[patrol_type_id] [int] NULL,
	[patrol_type_name] [nvarchar](50) NULL,
 CONSTRAINT [PK_patrol_records] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[patrol_records] ON
INSERT [dbo].[patrol_records] ([id], [create_time], [file_path], [user_id], [explain], [longitude], [latitude], [patrol_type_id], [patrol_type_name]) VALUES (4, CAST(0x0000A976009DB9DE AS DateTime), N'/patrol/20181011a16d53ca-0000-46b9-bcf3-53e00508f705.jpg', 9, N'wqutuzzzzzz', CAST(123.490453 AS Decimal(10, 6)), CAST(41.698509 AS Decimal(10, 6)), NULL, NULL)
INSERT [dbo].[patrol_records] ([id], [create_time], [file_path], [user_id], [explain], [longitude], [latitude], [patrol_type_id], [patrol_type_name]) VALUES (5, CAST(0x0000A97700A40FFF AS DateTime), N'/patrol/20181012848e062e-cef8-4f47-a9c0-0eac69ba4b65.jpg', 9, N'啊', CAST(123.437207 AS Decimal(10, 6)), CAST(41.820417 AS Decimal(10, 6)), NULL, NULL)
INSERT [dbo].[patrol_records] ([id], [create_time], [file_path], [user_id], [explain], [longitude], [latitude], [patrol_type_id], [patrol_type_name]) VALUES (6, CAST(0x0000A982017AC84E AS DateTime), N'/patrol/201810234ce25deb-10f8-452e-95c7-1eafd2e7d235.jpg', 9, N'测试', CAST(120.450881 AS Decimal(10, 6)), CAST(41.576054 AS Decimal(10, 6)), NULL, NULL)
INSERT [dbo].[patrol_records] ([id], [create_time], [file_path], [user_id], [explain], [longitude], [latitude], [patrol_type_id], [patrol_type_name]) VALUES (7, CAST(0x0000A98300921D23 AS DateTime), N'/patrol/201810249b419dce-1568-4e9b-a39f-bfb2ddce50c5.jpg', 9, N'水利站', CAST(120.408185 AS Decimal(10, 6)), CAST(41.500480 AS Decimal(10, 6)), NULL, NULL)
INSERT [dbo].[patrol_records] ([id], [create_time], [file_path], [user_id], [explain], [longitude], [latitude], [patrol_type_id], [patrol_type_name]) VALUES (8, CAST(0x0000A983009266DB AS DateTime), N'/patrol/20181024edad560c-158d-4926-ac52-9bf6f8d2cf2c.jpg', 9, N'视频头', CAST(120.440337 AS Decimal(10, 6)), CAST(41.484383 AS Decimal(10, 6)), NULL, NULL)
INSERT [dbo].[patrol_records] ([id], [create_time], [file_path], [user_id], [explain], [longitude], [latitude], [patrol_type_id], [patrol_type_name]) VALUES (9, CAST(0x0000A9830092B6F7 AS DateTime), N'/patrol/20181024ef52a9da-e928-43eb-90b8-8319fac024b1.jpg', 9, N'水位', CAST(120.440926 AS Decimal(10, 6)), CAST(41.484121 AS Decimal(10, 6)), NULL, NULL)
INSERT [dbo].[patrol_records] ([id], [create_time], [file_path], [user_id], [explain], [longitude], [latitude], [patrol_type_id], [patrol_type_name]) VALUES (10, CAST(0x0000A98300A0EB91 AS DateTime), N'/patrol/201810245e388cb1-f761-4774-832c-73d091fa69d9.jpg', 9, N'雨量站', CAST(120.349337 AS Decimal(10, 6)), CAST(41.111143 AS Decimal(10, 6)), NULL, NULL)
INSERT [dbo].[patrol_records] ([id], [create_time], [file_path], [user_id], [explain], [longitude], [latitude], [patrol_type_id], [patrol_type_name]) VALUES (11, CAST(0x0000A98300A18121 AS DateTime), N'/patrol/2018102437822deb-483f-4dbb-bf60-a9505c85f5c8.jpg', 9, N'自动雨量站', CAST(120.349337 AS Decimal(10, 6)), CAST(41.111143 AS Decimal(10, 6)), NULL, NULL)
INSERT [dbo].[patrol_records] ([id], [create_time], [file_path], [user_id], [explain], [longitude], [latitude], [patrol_type_id], [patrol_type_name]) VALUES (12, CAST(0x0000A98300A250EF AS DateTime), N'/patrol/201810244151b669-51fe-4784-b443-35ae0dadf169.jpg', 9, N'报警器', CAST(120.349335 AS Decimal(10, 6)), CAST(41.111098 AS Decimal(10, 6)), NULL, NULL)
INSERT [dbo].[patrol_records] ([id], [create_time], [file_path], [user_id], [explain], [longitude], [latitude], [patrol_type_id], [patrol_type_name]) VALUES (13, CAST(0x0000A98300A8B0E6 AS DateTime), N'/patrol/20181024fb40f3ed-3b42-42c8-b8f1-56b1d59ea114.jpg', 9, N'自动雨量站', CAST(120.266124 AS Decimal(10, 6)), CAST(41.019040 AS Decimal(10, 6)), NULL, NULL)
SET IDENTITY_INSERT [dbo].[patrol_records] OFF
/****** Object:  Table [dbo].[app_version]    Script Date: 11/26/2018 12:15:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[app_version](
	[version_id] [int] IDENTITY(1,1) NOT NULL,
	[version_name] [nvarchar](50) NULL,
	[code_int] [int] NULL,
	[version_code] [nvarchar](50) NULL,
	[downLoad_url] [nvarchar](500) NULL,
	[introduce] [nvarchar](500) NULL,
	[create_time] [datetime] NULL,
 CONSTRAINT [PK_app_version] PRIMARY KEY CLUSTERED 
(
	[version_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[app_version] ON
INSERT [dbo].[app_version] ([version_id], [version_name], [code_int], [version_code], [downLoad_url], [introduce], [create_time]) VALUES (1, N'V1.0.1', 2, N'2', N'/apk/201811024f63ba13-1f48-46d8-81c0-d8b3bc515ad9.apk', N'初始版本', CAST(0x0000A98C011EF0D4 AS DateTime))
SET IDENTITY_INSERT [dbo].[app_version] OFF
/****** Object:  Table [dbo].[admin_user]    Script Date: 11/26/2018 12:15:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[admin_user](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[account] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[user_name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_admin_user] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[admin_user] ON
INSERT [dbo].[admin_user] ([id], [account], [password], [user_name]) VALUES (1, N'admin', N'123456', N'管理员')
SET IDENTITY_INSERT [dbo].[admin_user] OFF
