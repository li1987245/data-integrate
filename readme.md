mysql> show character set;
+----------+-----------------------------+---------------------+--------+
| Charset  | Description                 | Default collation   | Maxlen |
+----------+-----------------------------+---------------------+--------+
| big5     | Big5 Traditional Chinese    | big5_chinese_ci     |      2 |
| dec8     | DEC West European           | dec8_swedish_ci     |      1 |
| cp850    | DOS West European           | cp850_general_ci    |      1 |
| hp8      | HP West European            | hp8_english_ci      |      1 |
| koi8r    | KOI8-R Relcom Russian       | koi8r_general_ci    |      1 |
| latin1   | cp1252 West European        | latin1_swedish_ci   |      1 |
| latin2   | ISO 8859-2 Central European | latin2_general_ci   |      1 |
| swe7     | 7bit Swedish                | swe7_swedish_ci     |      1 |
| ascii    | US ASCII                    | ascii_general_ci    |      1 |
| ujis     | EUC-JP Japanese             | ujis_japanese_ci    |      3 |
| sjis     | Shift-JIS Japanese          | sjis_japanese_ci    |      2 |
| hebrew   | ISO 8859-8 Hebrew           | hebrew_general_ci   |      1 |
| tis620   | TIS620 Thai                 | tis620_thai_ci      |      1 |
| euckr    | EUC-KR Korean               | euckr_korean_ci     |      2 |
| koi8u    | KOI8-U Ukrainian            | koi8u_general_ci    |      1 |
| gb2312   | GB2312 Simplified Chinese   | gb2312_chinese_ci   |      2 |
| greek    | ISO 8859-7 Greek            | greek_general_ci    |      1 |
| cp1250   | Windows Central European    | cp1250_general_ci   |      1 |
| gbk      | GBK Simplified Chinese      | gbk_chinese_ci      |      2 |
| latin5   | ISO 8859-9 Turkish          | latin5_turkish_ci   |      1 |
| armscii8 | ARMSCII-8 Armenian          | armscii8_general_ci |      1 |
| utf8     | UTF-8 Unicode               | utf8_general_ci     |      3 |
| ucs2     | UCS-2 Unicode               | ucs2_general_ci     |      2 |
| cp866    | DOS Russian                 | cp866_general_ci    |      1 |
| keybcs2  | DOS Kamenicky Czech-Slovak  | keybcs2_general_ci  |      1 |
| macce    | Mac Central European        | macce_general_ci    |      1 |
| macroman | Mac West European           | macroman_general_ci |      1 |
| cp852    | DOS Central European        | cp852_general_ci    |      1 |
| latin7   | ISO 8859-13 Baltic          | latin7_general_ci   |      1 |
| utf8mb4  | UTF-8 Unicode               | utf8mb4_general_ci  |      4 |
| cp1251   | Windows Cyrillic            | cp1251_general_ci   |      1 |
| utf16    | UTF-16 Unicode              | utf16_general_ci    |      4 |
| cp1256   | Windows Arabic              | cp1256_general_ci   |      1 |
| cp1257   | Windows Baltic              | cp1257_general_ci   |      1 |
| utf32    | UTF-32 Unicode              | utf32_general_ci    |      4 |
| binary   | Binary pseudo charset       | binary              |      1 |
| geostd8  | GEOSTD8 Georgian            | geostd8_general_ci  |      1 |
| cp932    | SJIS for Windows Japanese   | cp932_japanese_ci   |      2 |
| eucjpms  | UJIS for Windows Japanese   | eucjpms_japanese_ci |      3 |
+----------+-----------------------------+---------------------+--------+

-FEDERATED 引擎
跨库操作（不同实例，相同实例只需要【库名.表】操作即可）
## 启动
hadoop namenode -format(第一次)
start-dfs.sh
start-yarn.sh
mr-jobhistory-daemon.sh start historyserver
##配置
### core-site.xml

**属性名称**

**属性值**

**描述**

hadoop.common.configuration.version

0.23.0

配置文件的版本。

hadoop.tmp.dir

/tmp/hadoop-${user.name}

其它临时目录的父目录，会被其它临时目录用到。

io.native.lib.available

TRUE

是否使用本地库进行bz2和zlib的文件压缩及编解码。

hadoop.http.filter.initializers

org.apache.hadoop.http.lib.StaticUserWebFilter

一个逗号分隔的类名列表，他们必须继承于org.apache.hadoop.http.FilterInitializer，相应的过滤器被初始化后，将应用于所有的JSP和Servlet网页。列表的排序即为过滤器的排序。 

hadoop.security.authorization

FALSE

是否启用service级别的授权。

hadoop.security.instrumentation.requires.admin

FALSE

访问servlets (JMX, METRICS, CONF, STACKS)是否需要管理员ACL(访问控制列表)的授权。

hadoop.security.authentication

simple

有两个选项，simple和kerberos，两个的详细区别就自己百度吧。

hadoop.security.group.mapping

org.apache.hadoop.security.JniBasedUnixGroupsMappingWithFallback

用于ACL用户组映射的类，默认的实现类是 org.apache.hadoop.security.JniBasedUnixGroupsMappingWithFallback，定义了JNI是否可用，如果可用，将使用hadoop中的API来实现访问用户组解析，如果不可用，将使用ShellBasedUnixGroupsMapping来实现。

hadoop.security.dns.interface

　

用于确定Kerberos登录主机的网络接口的名称。

hadoop.security.dns.nameserver

　

用于确定Kerberos登录主机的地址。

hadoop.security.dns.log-slow-lookups.enabled

FALSE

当查询名称时间超过阈值时是否进行记录。

hadoop.security.dns.log-slow-lookups.threshold.ms

1000

接上一个属性，这个属性就是设置阈值的。

hadoop.security.groups.cache.secs

300

配置用户组映射缓存时间的，当过期时重新获取并缓存。

hadoop.security.groups.negative-cache.secs

30

当无效用户频繁访问，用于设置缓存锁定时间。建议设置为较小的值，也可以通过设置为0或负数来禁用此属性。

hadoop.security.groups.cache.warn.after.ms

5000

当查询用户组时间超过设置的这个阈值时，则作为警告信息进行记录。

hadoop.security.groups.cache.background.reload

FALSE

是否使用后台线程池重新加载过期的用户组映射。

hadoop.security.groups.cache.background.reload.threads

3

接上一个属性，当上个属性为true时，通过此属性控制后台线程的数量。

hadoop.security.groups.shell.command.timeout

0s

设置shell等待命令执行时间，如果超时，则命令中止，如果设置为0，表示无限等待。

hadoop.security.group.mapping.ldap.connection.timeout.ms

60000

设置LDAP的连接超时时间，如果为0或负数，表示无限等待。

hadoop.security.group.mapping.ldap.read.timeout.ms

60000

设置LDAP的读取超时时间，如果为0或负数，表示无限等待。

hadoop.security.group.mapping.ldap.url

　

LDAP服务器的地址。

hadoop.security.group.mapping.ldap.ssl

FALSE

是否使用SSL连接LDAP服务器。

hadoop.security.group.mapping.ldap.ssl.keystore

　

包含SSL证书的SSL密钥文件的存储路径。

hadoop.security.group.mapping.ldap.ssl.keystore.password.file

　

包括SSL密钥文件访问密码的文件路径，如果此属性没有设置，并且hadoop.security.group.mapping.ldap.ssl.keystore.password属性也没有设置，则直接从LDAP指定文件读取密码（注意：此文件只能由运行守护进程的unix用户读取，并且应该是本地文件）。

hadoop.security.group.mapping.ldap.ssl.keystore.password

　

保存SSL密钥文件访问密码的别名，如果此属性为空，并且hadoop.security.credential.clear-text-fallback属性为true时，则通过后者获取密码。

hadoop.security.credential.clear-text-fallback

TRUE

是否将密码保存为明文。

hadoop.security.credential.provider.path

　

包含证书类型和位置的文件地址列表。

hadoop.security.credstore.java-keystore-provider.password-file

　

包含用户自定义密码的文件路径。

hadoop.security.group.mapping.ldap.bind.user

　

连接到LDAP服务器时的用户别名，如果LDAP服务器支持匿名绑定，则此属性可以为空值。

hadoop.security.group.mapping.ldap.bind.password.file

　

包含绑定用户密码的文件的路径。如果在证书提供程序中没有配置密码，并且属性hadoop.security.group.mapping.ldap.bind.password没有设置，则从文件读取密码。注意：此文件只能由运行守护进程的UNIX用户读取，并且应该是本地文件。

hadoop.security.group.mapping.ldap.bind.password

　

绑定用户的密码。此属性名用作从凭据提供程序获取密码的别名。如果无法找到密码，hadoop.security.credential.clear-text-fallback是真的，则使用此属性的值作为密码。

hadoop.security.group.mapping.ldap.base

　

LDAP连接时搜索的根目录。

hadoop.security.group.mapping.ldap.userbase

　

指定用户LDAP连接时搜索的根目录。如果不设置此属性，则使用hadoop.security.group.mapping.ldap.base属性的值。

hadoop.security.group.mapping.ldap.groupbase

　

指定用户组LDAP连接时搜索的根目录。如果不设置此属性，则使用hadoop.security.group.mapping.ldap.base属性的值。

hadoop.security.group.mapping.ldap.search.filter.user

(&(objectClass=user)(sAMAccountName={0}))

搜索LDAP用户时提供的额外的筛选器。

hadoop.security.group.mapping.ldap.search.filter.group

(objectClass=group)

搜索LDAP用户组时提供的额外的筛选器。

hadoop.security.group.mapping.ldap.search.attr.memberof

　

用户对象的属性，用于标识其组对象。

hadoop.security.group.mapping.ldap.search.attr.member

member

用户组对象的属性，用于标识其有哪些组成员。

hadoop.security.group.mapping.ldap.search.attr.group.name

cn

用户组对象的属性，用于标识用户组的名称。

hadoop.security.group.mapping.ldap.search.group.hierarchy.levels

0

当要确定用户所属的用户组时，此属性用于指定向上查找的层级数目。如果为0，则表示只查询当前用户所属的直接用户组，不再向上查找。

hadoop.security.group.mapping.ldap.posix.attr.uid.name

uidNumber

 posixAccount的属性，用于成员分组

hadoop.security.group.mapping.ldap.posix.attr.gid.name

gidNumber

posixAccount的属性，用户标识组ID。

hadoop.security.group.mapping.ldap.directory.search.timeout

10000

 LDAP SearchControl的属性，用于在搜索和等待结果时设置最大时间限制。如果需要无限等待时间，设置为0。默认值为10秒。单位为毫秒。

hadoop.security.group.mapping.providers

　

逗号分隔的提供商名称，用于用户组映射。

hadoop.security.group.mapping.providers.combined

TRUE

标识提供商提供的级是否可以被组合。

hadoop.security.service.user.name.key

　

此属性用于指定RPC调用的服务主名称，适用于相同的RPC协议由多个服务器实现的情况。

fs.azure.user.agent.prefix

unknown

WASB提供给Azure的前缀，默认包括WASB版本、JAVA运行时版本、此属性的值等。

hadoop.security.uid.cache.secs

14400

控制缓存的过期时间。

hadoop.rpc.protection

authentication

一个逗号分隔的安全SASL连接的保护值列表。

hadoop.security.saslproperties.resolver.class

　

用于连接时解决QOP的SaslPropertiesResolver。

hadoop.security.sensitive-config-keys

secret$ password$ ssl.keystore.pass$ fs.s3.*\[Ss\]ecret.?\[Kk\]ey fs.s3a.*.server-side-encryption.key fs.azure.account.key.* credential$ oauth.*token$ hadoop.security.sensitive-config-keys

一个逗号分隔的或多行的正则表达式列表。

hadoop.workaround.non.threadsafe.getpwuid

TRUE

一些系统已知在调用getpwuid\_r和getpwgid\_r有问题，这些调用是非线程安全的。这个问题的主要表现特征是JVM崩溃。如果你的系统有这些问题，开启这个选项。默认是关闭的。

hadoop.kerberos.kinit.command

kinit

用于Kerberos证书的定时更新。

hadoop.kerberos.min.seconds.before.relogin

60

重新尝试登录Kerberos的最小时间间隔，单位为秒。

hadoop.security.auth\_to\_local

　

将Kerberos主体映射到本地用户名。

hadoop.token.files

　

具有Hadoop服务授权令牌的令牌缓存文件列表。

io.file.buffer.size

4096

在序列文件中使用的缓冲区大小。这个缓冲区的大小应该是页大小（英特尔x86上为4096）的倍数，它决定读写操作中缓冲了多少数据。

io.bytes.per.checksum

512

每个检验和的字节数，不能大于 io.file.buffer.size属性的值。

io.skip.checksum.errors

FALSE

如果为true，当读取序列文件时遇到校验和错误，则跳过条目，而不是抛出异常。

io.compression.codecs

　

一组可用于压缩/解压缩的表列表，使用逗号进行分隔。

io.compression.codec.bzip2.library

system-native

用于bzip2编解码的本地代码库，可以通过名称或全路径来指定该库。

io.serializations

org.apache.hadoop.io.serializer.WritableSerialization, org.apache.hadoop.io.serializer.avro.AvroSpecificSerialization, org.apache.hadoop.io.serializer.avro.AvroReflectSerialization

可用于获取序列化和反序列化的序列化类的列表。

io.seqfile.local.dir

${hadoop.tmp.dir}/io/local

存储中间数据文件的本地目录。

io.map.index.skip

0

跳过索引的数量。

io.map.index.interval

128

MapFile由两部分组成：数据文件和索引文件。在每个设置的时间间隔后，会根据写入的数据文件内容，创建索引对应的索引文件内容。

fs.defaultFS

file:///

默认文件系统的名称。通常指定namenode的URI地址，包括主机和端口。

fs.default.name

file:///

不建议使用此属性，建议用fs.defaultFS属性代替。

fs.trash.interval

0

检查点被删除的时间间隔，单位为分钟。此属性可以在服务器和客户端上配置。如果服务器上被禁用，则检查客户端配置，如果服务器上被启用，则忽略客户端配置。

fs.trash.checkpoint.interval

0

检查点之间的时间间隔，此属性的值应该小于fs.trash.interval属性的值。每次检查指针运行时，它都会创建一个新的检查点，并移除在几分钟前创建的检查点。

fs.protected.directories

　

一个逗号分隔的目录列表，即使是空的，也不能被超级用户删除。此设置可用于防止重要系统目录因管理员错误而意外删除。 

fs.AbstractFileSystem.file.impl

org.apache.hadoop.fs.local.LocalFs

file的抽象文件类。

fs.AbstractFileSystem.har.impl

org.apache.hadoop.fs.HarFs

har的抽象文件类。

fs.AbstractFileSystem.hdfs.impl

org.apache.hadoop.fs.Hdfs

hdfs的抽象文件类。

fs.AbstractFileSystem.viewfs.impl

org.apache.hadoop.fs.viewfs.ViewFs

viewfs的抽象文件类。

fs.viewfs.rename.strategy

SAME_MOUNTPOINT

允许在多个挂载点间重命名。

fs.AbstractFileSystem.ftp.impl

org.apache.hadoop.fs.ftp.FtpFs

ftp的抽象文件类。

fs.AbstractFileSystem.webhdfs.impl

org.apache.hadoop.fs.WebHdfs

webhdfs的抽象文件类。

fs.AbstractFileSystem.swebhdfs.impl

org.apache.hadoop.fs.SWebHdfs

swebhdfs的抽象文件类。

fs.ftp.host

0.0.0.0

ftp的连接服务器。

fs.ftp.host.port

21

ftp的连接服务器端口。

fs.ftp.data.connection.mode

ACTIVE\_LOCAL\_DATA\_CONNECTION\_MODE

ftp客户端的数据连接模式，有如下选项ACTIVE\_LOCAL\_DATA\_CONNECTION\_MODE，PASSIVE\_LOCAL\_DATA\_CONNECTION\_MODE 和PASSIVE\_REMOTE\_DATA\_CONNECTION\_MODE。

fs.ftp.transfer.mode

BLOCK\_TRANSFER\_MODE

ftp的数据传输模式，有如下选项 STREAM\_TRANSFER\_MODE，BLOCK\_TRANSFER\_MODE 和COMPRESSED\_TRANSFER\_MODE。

fs.df.interval

60000

磁盘使用统计情况的刷新时间间隔。

fs.du.interval

600000

文件空间使用统计情况的刷新时间间隔。

fs.s3.awsAccessKeyId

　

S3使用的AWS访问密钥ID。

fs.s3.awsSecretAccessKey

　

S3使用的AWS密钥.

fs.s3.block.size

67108864

S3使用的块大小。

fs.s3.buffer.dir

${hadoop.tmp.dir}/s3

该目录用于发送S3前的临时本地目录。

fs.s3.maxRetries

4

在向应用程序发出故障之前，读取或写入文件到S3的最大重试次数。

fs.s3.sleepTimeSeconds

10

在每次S3重试之间的睡眠时间间隔。

fs.swift.impl

org.apache.hadoop.fs.swift.snative.SwiftNativeFileSystem

OpenStack Swift Filesystem的实现类。

fs.automatic.close

TRUE

当为true时，FileSystem的实例会在程序退出时关闭，为false时，不自动退出。

fs.s3n.awsAccessKeyId

　

S3本地文件系统使用的AWS访问密钥ID。

fs.s3n.awsSecretAccessKey

　

S3本地文件系统使用的AWS密钥.

fs.s3n.block.size

67108864

S3本地文件系统使用的块大小。

fs.s3n.multipart.uploads.enabled

FALSE

为true时，允许多个上传到本地S3。当上传一个的大小超过fs.s3n.multipart.uploads.block.size属性的大小，则将其分割成块。

fs.s3n.multipart.uploads.block.size

67108864

多上传到本地S3时的块大小，默认大小为64MB。

fs.s3n.multipart.copy.block.size

5368709120

多拷贝时的块大小，默认大小为5GB。

fs.s3n.server-side-encryption-algorithm

　

为S3指定服务器端加密算法。默认情况下未设置，而当前唯一允许的值是AES256。

fs.s3a.access.key

　

S3A文件系统使用的AWS访问密钥ID。

fs.s3a.secret.key

　

S3A文件系统使用的AWS密钥。

fs.s3a.aws.credentials.provider

　

一组com.amazonaws.auth.AWSCredentialsProvider的实现类，按照顺序加载和查询。

fs.s3a.session.token

　

当使用org.apache.hadoop.fs.s3a.TemporaryAWSCredentialsProvider时的会话令牌。

fs.s3a.security.credential.provider.path

　

hadoop.security.credential.provider.path属性的一个子集

fs.s3a.connection.maximum

15

S3A的最大连接数。

fs.s3a.connection.ssl.enabled

TRUE

是否启用SSL连接到S3A。

fs.s3a.endpoint

　

AWS S3 连接终端。

fs.s3a.path.style.access

FALSE

启用S3A path style访问，即禁用默认虚拟的互联网行为。

fs.s3a.proxy.host

　

S3A连接代理的主机名。

fs.s3a.proxy.port

　

S3A连接代理的端口，如果未设置，默认为80或443。

fs.s3a.proxy.username

　

S3A连接代理的用户名。

fs.s3a.proxy.password

　

S3A连接代理的密码。

fs.s3a.proxy.domain

　

S3A连接代理的域。

fs.s3a.proxy.workstation

　

S3A连接代理的工作站。

fs.s3a.attempts.maximum

20

当出现错误时的最大重试次数。

fs.s3a.connection.establish.timeout

5000

Socket连接建立超时时间，单位为毫秒。

fs.s3a.connection.timeout

200000

Socket连接保持时间，单位为毫秒。

fs.s3a.socket.send.buffer

8192

Socket 发送缓冲大小，单位为字节。

fs.s3a.socket.recv.buffer

8192

Socket 接收缓冲大小，单位为字节。

fs.s3a.paging.maximum

5000

在读取目录列表时，从S3A同时请求的密钥最大数量。

fs.s3a.threads.max

10

文件请求的最大并发线程数。

fs.s3a.threads.keepalivetime

60

线程空间多长时间后，即终止。单位为秒。

fs.s3a.max.total.tasks

5

可以并发执行的操作数。

fs.s3a.multipart.size

100M

upload或copy操作，当文件超过多大时，即拆分。单位可以为K/M/G/T/P。

fs.s3a.multipart.threshold

2147483647

upload或copy或rename操作，当文件超过多大时，即拆分。单位可以为K/M/G/T/P，不写表示字节。

fs.s3a.multiobjectdelete.enable

TRUE

当启用时，多个单对象的删除，被单个多对象的删除替代，以减少请求数。

fs.s3a.acl.default

　

选项有Private、PublicRead,、PublicReadWrite、 AuthenticatedRead、LogDeliveryWrite、 BucketOwnerRead、 or BucketOwnerFullControl。

fs.s3a.multipart.purge

FALSE

当为true时，清除多文件上传失败时的文件。

fs.s3a.multipart.purge.age

86400

清理多文件上传的最小秒数。

fs.s3a.server-side-encryption-algorithm

　

为S3A指定服务器端加密算法，可以为 'AES256' (for SSE-S3)、 'SSE-KMS' 或 'SSE-C'.

fs.s3a.server-side-encryption.key

　

如果 fs.s3a.server-side-encryption-algorithm属性值为'SSE-KMS' or 'SSE-C'，则使用特定的加密密钥。在SSE-C的情况下，这个属性的值应该是Base64编码的密钥，在SSE-KMS的情况下，如果该属性为空，则使用默认的S3KMS密钥，否则应将该属性设置为特定的KMS密钥ID。

fs.s3a.signing-algorithm

　

重写默认签名算法。

fs.s3a.block.size

32M

S3A的块大小。

fs.s3a.buffer.dir

${hadoop.tmp.dir}/s3a

用于缓冲上传文件的目录。

fs.s3a.fast.upload

FALSE

是否启用基于增量块的快速上传机制。

fs.s3a.fast.upload.buffer

disk

选项可以为disk/array/bytebuffer。

fs.s3a.fast.upload.active.blocks

4

单个输出流可以激活的最大块数。

fs.s3a.readahead.range

64K

在关闭和重新打开S3 HTTP连接之前在seek()提前读取的字节。

fs.s3a.user.agent.prefix

　

设置一个自定义值，作为发送到S3的HTTP请求的头部。

fs.s3a.metadatastore.authoritative

FALSE

当为true时，允许元数据作为真实的数据源。

fs.s3a.metadatastore.impl

org.apache.hadoop.fs.s3a.s3guard.NullMetadataStore

实现S3A的元数据存储类的完全限定名。

fs.s3a.s3guard.cli.prune.age

86400000

删除命令执行后，元数据在设定时间后被删除，单位为毫秒。

fs.s3a.impl

org.apache.hadoop.fs.s3a.S3AFileSystem

S3A文件系统的实现类 。

fs.s3a.s3guard.ddb.region

　

AWS DynamoDB连接域。

fs.s3a.s3guard.ddb.table

　

DynamoDB操作表名，如果此属性没有被设置，则使用S3的桶名。

fs.s3a.s3guard.ddb.table.create

FALSE

当为true时，S3A客户端将允许创建不存在的表。

fs.s3a.s3guard.ddb.table.capacity.read

500

读操作的吞吐量设置。

fs.s3a.s3guard.ddb.table.capacity.write

100

写操作的吞吐量设置。

fs.s3a.s3guard.ddb.max.retries

9

批量DynamoDB操作报错或取消前的最大重试次数。

fs.s3a.s3guard.ddb.background.sleep

25

批量删除时，每个删除间的时间间隔，单位为毫秒。

fs.AbstractFileSystem.s3a.impl

org.apache.hadoop.fs.s3a.S3A

S3A抽象文件系统的实现类。

fs.wasb.impl

org.apache.hadoop.fs.azure.NativeAzureFileSystem

原生Azure文件系统的实现类。

fs.wasbs.impl

org.apache.hadoop.fs.azure.NativeAzureFileSystem$Secure

安全原生Azure文件系统的实现类。

fs.azure.secure.mode

FALSE

当为true时，允许 fs.azure.NativeAzureFileSystem使用SAS密钥与Azure存储进行通信。

fs.azure.local.sas.key.mode

FALSE

当为true时，fs.azure.NativeAzureFileSystem使用本地SAS密钥生成，当为false，此属性无意义。

fs.azure.sas.expiry.period

90d

生成的SAS密钥过期时间，单位可以是ms(millis)， s(sec)， m(min)， h(hour)， d(day) 。

fs.azure.authorization

FALSE

当为true时，启用WASB的授权支持。

fs.azure.authorization.caching.enable

TRUE

当为true时，开户授权结果的缓存。

fs.azure.saskey.usecontainersaskeyforallaccess

TRUE

当为true时，使用容器内的SAS密钥访问blob，专用密钥无效。

fs.adl.impl

org.apache.hadoop.fs.adl.AdlFileSystem

　

fs.AbstractFileSystem.adl.impl

org.apache.hadoop.fs.adl.Adl

　

io.seqfile.compress.blocksize

1000000

块压缩序列文件中压缩的最小块大小。

io.mapfile.bloom.size

1048576

BloomMapFile中的bloom过滤器大小。

io.mapfile.bloom.error.rate

0.005

BloomMapFile中的bloom过滤器的假负率，默认是0.5%。

hadoop.util.hash.type

murmur

Hash的默认实现，有两个选项murmur和jenkins。

ipc.client.idlethreshold

4000

定义连接的阈值数量，之后将检查连接是否空闲。

ipc.client.kill.max

10

定义一次断开的客户端的最大数量。

ipc.client.connection.maxidletime

10000

空间连接断开时间，单位为毫秒。

ipc.client.connect.max.retries

10

客户端重新建立服务器连接的重试次数。

ipc.client.connect.retry.interval

1000

两次重新建立连接之间的时间间隔，单位为毫秒。

ipc.client.connect.timeout

20000

客户端通过socket连接到服务器的超时时间。

ipc.client.connect.max.retries.on.timeouts

45

客户端通过socket重新连接到服务器的重试次数。

ipc.client.tcpnodelay

TRUE

当为true时，使用TCP_NODELAY标志绕过Nagle的算法传输延迟。

ipc.client.low-latency

FALSE

当为true时，使用低延迟在QoS标记。

ipc.client.ping

TRUE

当为true时，如果读取响应超时，则向服务器发送ping命令。

ipc.ping.interval

60000

等待服务器响应的超时时间，单位为毫秒。当ipc.client.ping属性为true时，客户端将在不接收字节的情况下发送Ping命令。

ipc.client.rpc-timeout.ms

0

等待服务器响应的超时时间，单位为毫秒。当ipc.client.ping属性为true，并且这个属性的时间比 ipc.ping.interval属性的值大时，这个属性的时间将被修改为 ipc.ping.interval的最大倍数。

ipc.server.listen.queue.size

128

接受客户端连接的服务器的侦听队列的长度。

ipc.server.log.slow.rpc

FALSE

此设置有助于排除各种服务的性能问题。如果这个值设置为true，将被记录请求。

ipc.maximum.data.length

67108864

服务器可以接受的最大IPC消息长度（字节）。

ipc.maximum.response.length

134217728

服务器可以接受的最大IPC消息长度（字节）。设置为0禁用。

hadoop.security.impersonation.provider.class

　

ImpersonationProvider接口的实现类，用于授权一个用户是否可以模拟特定用户。如果未指定，则使用DefaultImpersonationProvider实现。

hadoop.rpc.socket.factory.class.default

org.apache.hadoop.net.StandardSocketFactory

默认使用SocketFactory，参数格式为package.FactoryClassName。

hadoop.rpc.socket.factory.class.ClientProtocol

　

连接到DFS的SocketFactory，如果为空，则使用 hadoop.rpc.socket.class.default属性的值。

hadoop.socks.server

　

SocksSocketFactory使用的SOCKS服务器的地址（主机：端口）。

net.topology.node.switch.mapping.impl

org.apache.hadoop.net.ScriptBasedMapping

DNSToSwitchMapping的默认实现，其调用net.topology.script.file.name属性的值来解析节点名称。

net.topology.impl

org.apache.hadoop.net.NetworkTopology

NetworkTopology的默认实现，它是典型的三层拓扑结构。

net.topology.script.file.name

　

该脚本被用于解析DNS的名称，例如，脚本将接收host.foo.bar，然后返回 /rack1。

net.topology.script.number.args

100

net.topology.script.file.name属性中参数的最大数量。

net.topology.table.file.name

　

当net.topology.node.switch.mapping.impl属性的值为 org.apache.hadoop.net.TableMapping时适用，表示一个拓扑文件。该文件格式是两列文本，列由空白分隔。第一列是DNS或IP地址，第二列指定地址映射的机架。如果没有找到对应于集群中的主机的条目，则假设默认机架。

file.stream-buffer-size

4096

流文件的缓冲区大小，这个大小应该是页大小的位数（X86为4096）。

file.bytes-per-checksum

512

每个校验和的字节数。

file.client-write-packet-size

65536

客户机写入的数据包大小。

file.blocksize

67108864

块大小。

file.replication

1

复制因子。

s3.stream-buffer-size

4096

流文件的缓冲区大小，这个大小应该是页大小的位数（X86为4096）。

s3.bytes-per-checksum

512

每个校验和的字节数，该数值不能大于 s3.stream-buffer-size属性的值。

s3.client-write-packet-size

65536

客户机写入的数据包大小。

s3.blocksize

67108864

块大小。

s3.replication

3

复制因子。

s3native.stream-buffer-size

4096

流文件的缓冲区大小，这个大小应该是页大小的位数（X86为4096）。

s3native.bytes-per-checksum

512

每个校验和的字节数，该数值不能大于 s3native.stream-buffer-size属性的值。

s3native.client-write-packet-size

65536

客户机写入的数据包大小。

s3native.blocksize

67108864

块大小。

s3native.replication

3

复制因子。

ftp.stream-buffer-size

4096

流文件的缓冲区大小，这个大小应该是页大小的位数（X86为4096）。

ftp.bytes-per-checksum

512

每个校验和的字节数，该数值不能大于ftp.stream-buffer-size属性的值。

ftp.client-write-packet-size

65536

客户机写入的数据包大小。

ftp.blocksize

67108864

块大小。

ftp.replication

3

复制因子。

tfile.io.chunk.size

1048576

chunk大小，单位为字节，默认为1MB。

tfile.fs.output.buffer.size

262144

FSDataOutputStream中使用的缓冲区大小。

tfile.fs.input.buffer.size

262144

FSDataInputStream使用的缓冲区大小。

hadoop.http.authentication.type

simple

定义了Oozie HTTP终端的认证方式，支持simple和kerberos。

hadoop.http.authentication.token.validity

36000

验证令牌的有效时长，单位为秒。

hadoop.http.authentication.signature.secret.file

${user.home}/hadoop-http-auth-signature-secret

签署认证令牌的签名秘密。同样的秘密应该用于JT/NN/DN/TT配置。

hadoop.http.authentication.cookie.domain

　

用于存储身份验证令牌的HTTP Cookie域。为了授权在所有Hadoop节点Web控制台上正确工作，必须正确设置域。重要事项：当使用IP地址时，浏览器忽略具有域设置的Cookie。为了使该设置正常工作，集群中的所有节点必须配置为具有主机名的URL。

hadoop.http.authentication.simple.anonymous.allowed

TRUE

当使用'simple'认证时，是否允许匿名请求。

hadoop.http.authentication.kerberos.principal

HTTP/_HOST@LOCALHOST

HTTP终端中使用的Kerberos principal，该principal必须以 'HTTP/'开头。

hadoop.http.authentication.kerberos.keytab

${user.home}/hadoop.keytab

keytab文件的位置。

hadoop.http.cross-origin.enabled

FALSE

是否启用cross-origin (CORS)过滤器。

hadoop.http.cross-origin.allowed-origins

*

需要cross-origin (CORS)支持的web服务的来源列表，用逗号分隔。

hadoop.http.cross-origin.allowed-methods

GET,POST,HEAD

需要cross-origin (CORS)支持的方法列表，用逗号分隔。

hadoop.http.cross-origin.allowed-headers

X-Requested-With,Content-Type,Accept,Origin

需要cross-origin (CORS)支持的web服务的的头部，用逗号分隔。

hadoop.http.cross-origin.max-age

1800

需要cross-origin (CORS)支持的web服务缓存支持秒数。

dfs.ha.fencing.methods

　

fencing方法列表。

dfs.ha.fencing.ssh.connect-timeout

30000

SSH连接超时时长，单位为毫秒。

dfs.ha.fencing.ssh.private-key-files

　

SSH私钥文件。

hadoop.http.staticuser.user

dr.who

呈现内容时在静态Web筛选器上进行过滤的用户名，比如在HDFS web UI中的过滤。

ha.zookeeper.quorum

　

ZooKeeper服务器地址列表，用逗号分隔，可以被ZKFailoverController用于自动故障转移。

ha.zookeeper.session-timeout.ms

5000

ZKFC连接到ZooKeeper的超时时长，将该值设置为较低的值意味着服务器崩溃将被更快地检测到，但在瞬态错误或网络错误的情况下，就会使故障转移过于激进。

ha.zookeeper.parent-znode

/hadoop-ha

ZKFC下的存储信息的znode。

ha.zookeeper.acl

world:anyone:rwcda

znode使用的ZooKeeper ACL列表，用逗号分隔。格式同ZooKeeper CLI。如果ACL本身包含秘密，那么您可以指定一个文件的路径，用“@”符号前缀，并且该配置的值将从内部加载。

ha.zookeeper.auth

　

连接到ZooKeeper时，将该列表加入到认证列表，此列表用逗号分隔。

hadoop.ssl.keystores.factory.class

org.apache.hadoop.security.ssl.FileBasedKeyStoresFactory

用于检索证书的密钥存储工厂。

hadoop.ssl.require.client.cert

FALSE

是否需要客户端证书。

hadoop.ssl.hostname.verifier

DEFAULT

提供HttpsURL连接主机名验证器。有以下选项：DEFAULT， STRICT， STRICT\_IE6， DEFAULT\_AND\_LOCALHOST 和 ALLOW\_ALL。

hadoop.ssl.server.conf

ssl-server.xml

提取SSL服务器密钥存储信息的资源文件，这个文件通过在classpath中查询。默认为hadoop下的conf/ 目录。

hadoop.ssl.client.conf

ssl-client.xml

提取SSL客户端密钥存储信息的资源文件，这个文件通过在classpath中查询。默认为hadoop下的conf/ 目录。

hadoop.ssl.enabled

FALSE

不建议使用，建议用dfs.http.policy and yarn.http.policy代替。

hadoop.ssl.enabled.protocols

TLSv1,SSLv2Hello,TLSv1.1,TLSv1.2

支持的SSL协议列表。The supported SSL protocols.

hadoop.jetty.logs.serve.aliases

TRUE

对于jetty的服务是否启用别名。

fs.permissions.umask-mode

22

创建文件或目录时的umask。例如"022" (符号表示就是 u=rwx,g=r-x,o=r-x )，或者 "u=rwx,g=rwx,o=" (用八进制表示就是007)。

ha.health-monitor.connect-retry-interval.ms

1000

重试连接到服务的频率。

ha.health-monitor.check-interval.ms

1000

多久检查一次服务

ha.health-monitor.sleep-after-disconnect.ms

1000

在异常RPC错误之后，休眠多长时间。

ha.health-monitor.rpc-timeout.ms

45000

实际 monitorHealth() 调用超时时间。

ha.failover-controller.new-active.rpc-timeout.ms

60000

FC等待新任务的超时时间，在设置时间内有新任务，即重新进入激活状态。

ha.failover-controller.graceful-fence.rpc-timeout.ms

5000

FC等待旧任务的超时时间，然后进入待机。

ha.failover-controller.graceful-fence.connection.retries

1

graceful fencing中FC连接的重试次数。

ha.failover-controller.cli-check.rpc-timeout.ms

20000

CLI (manual) FC等待monitorHealth, getServiceState的超时时间。

ipc.client.fallback-to-simple-auth-allowed

FALSE

当客户端被配置为尝试安全连接，但尝试连接到不安全的服务器时，该服务器可以指示客户端切换到SASL SIMPLE（非安全）认证。此设置控制客户端是否将接受来自服务器的此指令。当FALSE（默认）时，客户端将不允许退回到简单的身份验证，并将中止连接。 

fs.client.resolve.remote.symlinks

TRUE

在访问远程Hadoop文件系统时，是否解析符号连接。当为false时，如果遇到符号连接，则触发异常。此设置对于本地文件系统不适用，对于本地文件系统，会自动解析符号连接。

nfs.exports.allowed.hosts

\* rw

默认情况下，所有客户端都可以导出。该属性的值包含机构号和访问权限，由空格分隔。机器名称的格式可以是一个单一的主机，一个java正则表达式，或一个IPv4地址。访问特权使用RW或RO来指定机器的读/写权限。如果未提供访问特权，则默认为只读。条目由“；”分隔。例如：“192.1680.0/22RW；主机。*.Stase\\.com；Hoo1.Test.Org Ro；”。只有更新了NFS网关之后，才能重新启动该属性。

hadoop.user.group.static.mapping.overrides

dr.who=;

用户到组的静态映射。如果指定的用户在系统中可用，则这将覆盖组。换句话说，这些用户不会出现组查找，而是使用在这个配置中映射的组。映射应采用这种格式。USER1＝GROMP1，GROP2；USER2=；USER3= GROP2；默认“DR.WH=”将考虑“D.WHO”作为没有组的用户。

rpc.metrics.quantile.enable

FALSE

当为true，并且rpc.metrics.percentiles.intervals属性为一组逗号分隔的度量时，将在百分位50/75/90/95/99时，加入rpc metrics。

rpc.metrics.percentiles.intervals

　

接上一属性，和rpc.metrics.quantile.enable配合使用。

hadoop.security.crypto.codec.classes.EXAMPLECIPHERSUITE

　

对于给定的加密编解码器的前缀，包含一个逗号分隔的给定密码编解码器（例如EXAMPLECIPHERSUITE）的实现类。如果可用的话，第一个实现将被使用，其他的则是回退。

hadoop.security.crypto.codec.classes.aes.ctr.nopadding

org.apache.hadoop.crypto.OpensslAesCtrCryptoCodec, org.apache.hadoop.crypto.JceAesCtrCryptoCodec

AES/CTR/NopAudio的加密编解码器实现类，用逗号分隔。如果可用的话，第一个实现将被使用，其他的则是回退。

hadoop.security.crypto.cipher.suite

AES/CTR/NoPadding

用于加密编解码器的密码套件。

hadoop.security.crypto.jce.provider

　

CryptoCodec中使用的JCE提供程序名称。

hadoop.security.crypto.buffer.size

8192

CryptoInputStream和CryptoOutputStream使用的缓冲区大小。

hadoop.security.java.secure.random.algorithm

SHA1PRNG

java安全随机算法。

hadoop.security.secure.random.impl

　

安全随机的实现。

hadoop.security.random.device.file.path

/dev/urandom

OS安全随机设备文件路径。

hadoop.security.key.provider.path

　

在管理区域密钥时使用的密钥提供程序。对于HDFS客户端，提供程序路径将与NAMENODE的提供程序路径相同。 

fs.har.impl.disable.cache

TRUE

当为true时，不缓存“HAR”文件系统实例。

hadoop.security.kms.client.authentication.retry-count

1

在认证失败时重试连接到KMS的次数。

hadoop.security.kms.client.encrypted.key.cache.size

500

EncryptedKeyVersion缓存队列的大小。

hadoop.security.kms.client.encrypted.key.cache.low-watermark

0.3f

如果EncryptedKeyVersion缓存队列大小低于watermark，队列将被重新调度填充。

hadoop.security.kms.client.encrypted.key.cache.num.refill.threads

2

重新填充EncryptedKeyVersion缓存队列的线程数。

hadoop.security.kms.client.encrypted.key.cache.expiry

43200000

密钥过期时间，默认为12小时。

hadoop.security.kms.client.timeout

60

KMS连接超时时间。

hadoop.security.kms.client.failover.sleep.base.millis

100

在故障转移尝试之间以指数形式增加时长，这是迄今为止尝试的数目的函数，具有\+/\- 50%的随机因子。此选项指定在故障转移计算中使用的基值。第一次故障转移将立即重试。第二次故障转移尝试将延迟至少hadoop.security.client.failover.sleep.base.millis属性的值之后……单位为毫秒

hadoop.security.kms.client.failover.sleep.max.millis

2000

在故障转移尝试之间以指数形式增加时长，这是迄今为止尝试的数目的函数，具有\+/\- 50%的随机因子。此选项指定在故障转移之间等待的最大值。具体来说，两个故障转移尝试之间的时间将不超过 hadoop.security.client.failover.sleep.max.millis属性的值，单位为毫秒。

ipc.server.max.connections

0

服务器接受的最大并发连接数。

hadoop.registry.rm.enabled

FALSE

是否在YARN Resource Manager中启用注册表。

hadoop.registry.zk.root

/registry

注册表的根zookeeper节点。

hadoop.registry.zk.session.timeout.ms

60000

Zookeeper会话超时时间，单位为毫秒。

hadoop.registry.zk.connection.timeout.ms

15000

Zookeeper连接超时时间，单位为毫秒。

hadoop.registry.zk.retry.times

5

Zookeeper连接重试最大次数。

hadoop.registry.zk.retry.interval.ms

1000

Zookeeper连接重试间隔。

hadoop.registry.zk.retry.ceiling.ms

60000

Zookeeper重试的时长限制，单位为毫秒。

hadoop.registry.zk.quorum

localhost:2181

绑定注册表的zookeeper的主机名列表。

hadoop.registry.secure

FALSE

注册表是否是安全的。

hadoop.registry.system.acls

sasl:yarn@, sasl:mapred@, sasl:hdfs@

可以安全访问注册表的 zookeeper ACL列表。

hadoop.registry.kerberos.realm

　

Kerberos域。

hadoop.registry.jaas.context

Client

定义 JAAS上下文的密钥，用于安全模式中。

hadoop.shell.missing.defaultFs.warning

FALSE

如果fs.defaultFS属性未设置，则在hdfs中启用shell命令打印警告信息。 

hadoop.shell.safely.delete.limit.num.files

100

使用hadoop fs -rm的-safe选项，以避免意外删除大目录。 当启用时，如果要删除的文件数量大于该限制，则-RM命令需要确认。默认的限制是100个文件。如果限制为0或在-RM命令中未指定安全性，则禁用警告。

fs.client.htrace.sampler.classes

　

hadoop文件系统客户端使用的HTrace Samplers类名。

hadoop.htrace.span.receiver.classes

　

hadoop中使用的Span Receivers类名。

hadoop.http.logs.enabled

TRUE

当为true时，启用hadoop守护进程上的/logs终端。

fs.client.resolve.topology.enabled

FALSE

是否使用net.topology.node.switch.mapping.impl属性的值来计算客户端到远程机器之间的网络距离。

fs.adl.impl

org.apache.hadoop.fs.adl.AdlFileSystem

　

fs.AbstractFileSystem.adl.impl

org.apache.hadoop.fs.adl.Adl

　

adl.feature.ownerandgroup.enableupn

FALSE

为了获得最佳性能，建议使用FALSE。

fs.adl.oauth2.access.token.provider.type

ClientCredential

定义了Azure Active Directory OAuth2访问令牌提供程序类型。

fs.adl.oauth2.client.id

　

OAuth2客户端ID。

fs.adl.oauth2.credential

　

OAuth2访问密钥。

fs.adl.oauth2.refresh.url

　

OAuth2令牌终端。

fs.adl.oauth2.refresh.token

　

OAuth2刷新令牌。

fs.adl.oauth2.access.token.provider

　

OAuth2访问令牌提供程序的类名。

fs.adl.oauth2.msi.port

　

MSI令牌服务的本地端口，端口是在创建Azure VM时被指定的。如果未被指定，则用默认的50342。

fs.adl.oauth2.devicecode.clientapp.id

　

ADD本地app的ID。

hadoop.caller.context.enabled

FALSE

当为true时，附加的内容会被写入到namenode的log。

hadoop.caller.context.max.size

128

调用内容的最大字节数。

hadoop.caller.context.signature.max.size

40

服务器中允许签名的最大字节。

seq.io.sort.mb

100

当使用SequenceFile.Sorter时，可以用于排序的缓冲区总大小。单位为兆字节。默认情况下，每个合并流为1MB。

seq.io.sort.factor

100

当使用SequenceFile.Sorter时，允许同时合并的流数量。

hadoop.zk.address

　

ZooKeeper服务器地址。

hadoop.zk.num-retries

1000

尝试连接到ZooKeeper的数量。

hadoop.zk.retry-interval-ms

1000

连接到ZooKeeper的重试时间间隔，单位为毫秒。

hadoop.zk.timeout-ms

10000

ZooKeeper会话超时时间，单位为毫秒。 

hadoop.zk.acl

world:anyone:rwcda

用于ZooKeeper znode的ACL。

hadoop.zk.auth

　

为hadoop.zk.acl属性中的ACL指定认证方式。

### hdfs-site.xml



**属性名称**

**属性值**

**描述**

hadoop.hdfs.configuration.version

1

配置文件的版本

dfs.namenode.rpc-address

　

处理所有客户端请求的RPC地址，若在HA场景中，可能有多个namenode，就把名称ID添加到进来。该属性的格式为nn-host1:rpc-port。

dfs.namenode.rpc-bind-host

　

RPC服务器的真实地址，如果为空，则使用dfs.namenode.rpc-address属性中配置的主机名。该属性如果在HA场景中，可以在每个namenode中都指定。如果设置为0.0.0.0，则会在此namenode中监听所有的接口。

dfs.namenode.servicerpc-address

　

用于HDFS服务通信的RPC地址，所有的backupnode,datanode和其它服务都应该连接到这个地址。如果该属性未设置，则使用dfs.namenode.rpc-address属性的值。

dfs.namenode.servicerpc-bind-host

　

RPC服务器中服务的真实地址，如果为空，则使用dfs.namenode.servicerpc-bind-host属性中配置的主机名。该属性如果在HA场景中，可以在每个namenode中都指定。如果设置为

dfs.namenode.lifeline.rpc-address

　

namenode rpc 生命线地址。用于将实现轻量级的心跳检测，如果该属性为空，则不启用lifeline服务器。默认情况下，该属性是空的。

dfs.namenode.lifeline.rpc-bind-host

　

生命线RPC服务器的真实地址。

dfs.namenode.secondary.http-address

0.0.0.0:50090

secondary namenode HTTP服务器地址和端口。

dfs.namenode.secondary.https-address

0.0.0.0:50091

secondary namenode HTTPS服务器地址和端口。

dfs.datanode.address

0.0.0.0:50010

datanode服务器地址和端口。

dfs.datanode.http.address

0.0.0.0:50075

datanode HTTP服务器地址和端口。

dfs.datanode.ipc.address

0.0.0.0:50020

datanode IPC服务器地址和端口。

dfs.datanode.handler.count

10

datanode的服务器线程数。

dfs.namenode.http-address

0.0.0.0:50070

namenode web UI监听的地址和端口。

dfs.namenode.http-bind-host

　

HTTP服务器绑定的真实地址。

dfs.namenode.heartbeat.recheck-interval

300000

心跳检测的时间间隔，单位是毫秒。

dfs.http.policy

HTTP_ONLY

用于配置是否在HDFS上支持HTTPS(SSL)。选项有HTTP\_ONLY:只支持HHTPS； HTTPS\_ONLY:只支持HTTPS； HTTPS\_AND\_HTTPS:同时支持HTTP和HTTPS。

dfs.client.https.need-auth

FALSE

是否需要SSL客户端证书身份验证。

dfs.client.cached.conn.retry

3

HDFS客户端从缓存中提取套接字的次数。一旦超过这个数量，客户端将尝试创建一个新的套接字。

dfs.https.server.keystore.resource

ssl-server.xml

用于提取SSL服务器密钥存储信息的资源文件。

dfs.client.https.keystore.resource

ssl-client.xml

用于提取SSL客户端密钥存储信息的资源文件。

dfs.datanode.https.address

0.0.0.0:50475

datanode安全http服务器地址和端口。

dfs.namenode.https-address

0.0.0.0:50470

namenode安全http服务器地址和端口。

dfs.namenode.https-bind-host

　

HTTPS的真实地址。

dfs.datanode.dns.interface

default

datanode的网络接口名称，例如eth2。建议使用hadoop.security.dns.interface代替dfs.datanode.dns.interface。

dfs.datanode.dns.nameserver

default

DNS服务器的主机名或IP地址。建议使用hadoop.security.dns.nameserver代替dfs.datanode.dns.nameserver。

dfs.namenode.backup.address

0.0.0.0:50100

backup节点服务器地址和端口。如果端口为0，那么服务器将在自由端口启动。

dfs.namenode.backup.http-address

0.0.0.0:50105

backup节点http服务器地址和端口。如果端口为0，那么服务器将在自由端口启动。

dfs.namenode.replication.considerLoad

TRUE

在选择目标的时候，是否考虑目标的负载情况。

dfs.namenode.replication.considerLoad.factor

2

在dfs.namenode.replication.considerLoad属性设置为true的情况下，当节点的负载超过平均值时，则拒绝写入。

dfs.default.chunk.view.size

32768

在浏览器上能查看文件的字节数。

dfs.datanode.du.reserved

0

每卷保留字节的空间。

dfs.namenode.name.dir

file://${hadoop.tmp.dir}/dfs/name

存放namenode的名称表（fsimage）的目录，如果这是一个逗号分隔的目录列表，那么在所有目录中复制名称表，用于冗余。

dfs.namenode.name.dir.restore

FALSE

如果为true，则允许namenode尝试恢复之前失败的dfs.namenode.name.dir目录。当启用时，在检查点期间会尝试恢复任何失败的目录。

dfs.namenode.fs-limits.max-component-length

255

定义路径中每个组件中UTF-8编码的最大字节数。0的值将禁用检查。 

dfs.namenode.fs-limits.max-directory-items

1048576

定义目录可能包含的最大项目数。无法将属性设置为小于1或大于6400000的值。 

dfs.namenode.fs-limits.min-block-size

1048576

最小的块大小，单位为字节。

dfs.namenode.fs-limits.max-blocks-per-file

1048576

每个文件的最大块数。

dfs.namenode.edits.dir

${dfs.namenode.name.dir}

存放namenode的事务文件（edits）的目录，如果这是一个逗号分隔的目录列表，那么事务文件在所有目录中被复制，用于冗余。默认与dfs.namenode.name.dir属性目录一样。

dfs.namenode.edits.dir.required

　

是dfs.namenode.edits.dir属性目录的子集，用于确保这些edits文件目录是最新的。

dfs.namenode.shared.edits.dir

　

用于HA场景中，多个namenode共享的目录。

dfs.namenode.edits.journal-plugin.qjournal

org.apache.hadoop.hdfs.qjournal.client.QuorumJournalManager

　

dfs.permissions.enabled

TRUE

当为true时，则允许HDFS的检测，当为false时，则关闭HDFS的检测，但不影响其它HDFS的其它功能。

dfs.permissions.superusergroup

supergroup

超级用户组的名称。该值应该是单个组名。 

dfs.cluster.administrators

　

管理员ACL列表，用于控制谁可以访问namenode的servlet，这个属性由逗号分隔，例如"user1,user2 group1,group2"。用户和组都可以为空，所以 "user1", " group1", "", "user1 group1", "user1,user2 group1,group2" 都是有效的。 '*' 表示授予所有用户和组的访问权限。

dfs.namenode.acls.enabled

FALSE

当为false时，拒绝所有与设置或获取ACL相关的RPC，默认情况下是false。

dfs.namenode.lazypersist.file.scrub.interval.sec

300

namenode扫描lazypersist文件的时间间隔，当设置为负值时，则禁用此属性。

dfs.block.access.token.enable

FALSE

当为true时，允许访问令牌访问datanode。

dfs.block.access.key.update.interval

600

namenode更新其访问密钥的时间间隔，单位为分钟。

dfs.block.access.token.lifetime

600

访问令牌的生命周期，单位为分钟。

dfs.datanode.data.dir

file://${hadoop.tmp.dir}/dfs/data

存放datanode块的目录。如果这是一个逗号分隔的目录列表，那么数据将存储在所有命名的目录中，通常存储在不同的设备上。

dfs.datanode.data.dir.perm

700

datanode目录权限，可以为八进制，也可以为符号。

dfs.replication

3

副本数量。可以在创建文件时指定副本的实际数目。如果在创建时未指定复制，则使用默认值。

dfs.replication.max

512

最大副本数量。

dfs.namenode.replication.min

1

最小副本数量。

dfs.namenode.maintenance.replication.min

1

在维护模式时的最小活跃副本数量。

dfs.namenode.safemode.replication.min

　

用于计算安全块数量的最小副本数，当没有被设置时，则使用dfs.namenode.replication.min属性的值。

dfs.blocksize

134217728

新文件的块大小，单位为字节。可以使用如下后缀：k(kilo), m(mega), g(giga), t(tera), p(peta), e(exa) ，例如128k, 512m, 1g等。

dfs.client.block.write.retries

3

datanode写入失败时，尝试重新写入的次数。

dfs.client.block.write.replace-datanode-on-failure.enable

TRUE

当为true时，如果datanode写入失败，则重新写入新的datanode。

dfs.client.block.write.replace-datanode-on-failure.policy

DEFAULT

当dfs.client.block.write.replace-datanode-on-failure.enable属性为true时，该属性有效。选项有以下几种：ALWAYS，NEVER，DEFAULT。

dfs.client.block.write.replace-datanode-on-failure.best-effort

FALSE

当dfs.client.block.write.replace-datanode-on-failure.enable属性为true时使用。Best effort表示在继续写入新datanode时，如果仍然写入失败时采取的策略。当该属性为true时，如果新datanode写入失败，则继续找新的datanode写入；当该属性为false时，如果新datanode写入失败，则不再尝试写入新datanode，而是抛出异常。

dfs.client.block.write.replace-datanode-on-failure.min-replication

0

如果剩余datanode的数量小于该属性的值，则会抛出异常。详细要参考dfs.client.block.write.replace-datanode-on-failure.policy属性。

dfs.blockreport.intervalMsec

21600000

块报告的时间间隔，以毫秒为单位。

dfs.blockreport.initialDelay

0

第一次块报告的时间延迟，以秒为单位。

dfs.blockreport.split.threshold

1000000

当datanode的块数量小于该属性的值时，将用一条消息发送所有目录的块报告，如果datanode的块数量大于该属性的值，则每个目录用单独的消息发送块报告。

dfs.namenode.max.full.block.report.leases

6

所有块报告的最大数量。这个数字不应该超过RPC处理器线程数或小于1。

dfs.namenode.full.block.report.lease.length.ms

300000

namenode等待块报告的超时时间，单位为毫秒。

dfs.datanode.directoryscan.interval

21600

datanode以秒为单位扫描数据目录，并协调内存块和磁盘上的块之间的差异。

dfs.datanode.directoryscan.threads

1

线程池中用于编制卷报告的线程数。

dfs.datanode.directoryscan.throttle.limit.ms.per.sec

1000

每秒钟用于报告编译的线程的运行时间，当有多个线程时，该属性的时间是多个线程的累计时间。

dfs.heartbeat.interval

3

datanode的心跳时间间隔，单位为秒。

dfs.datanode.lifeline.interval.seconds

　

从datanode向namenode发送lifeline的时间间隔，单位为秒。该属性的值必须大于dfs.heartbeat.interval属性的值。

dfs.namenode.handler.count

10

RPC服务器的监听client线程数，如果dfs.namenode.servicerpc-address属性没有配置，则线程会监听所有节点的请求。

dfs.namenode.service.handler.count

10

只有当dfs.namenode.servicerpc-address属性配置后，该属性才有效。用于配置datanode和其它非client节点的监听线程数。

dfs.namenode.lifeline.handler.ratio

0.1

dfs.namenode.handler.count属性中，用于处理lifeline RPC服务的线程比例。例如dfs.namenode.handler.count属性值为100，并且dfs.namenode.lifeline.handler.ratio属性的值设置为0.10，则有10个线程用于处理lifeline rpc服务。

dfs.namenode.lifeline.handler.count

　

用于处理datanode lifeline协议的RPC服务器线程数量 。

dfs.namenode.safemode.threshold-pct

0.999f

dfs.namenode.replication.min属性中副本需要满足的块的百分比。

dfs.namenode.safemode.min.datanodes

0

在退出安全模式前，需要满足活跃的datanode的数量。

dfs.namenode.safemode.extension

30000

在达到阈值后，经过多长时间后会退出安全模式，单位为毫秒。

dfs.namenode.resource.check.interval

5000

namenode resource checker运行的时间间隔，单位为毫秒。

dfs.namenode.resource.du.reserved

104857600

存储或请求namenode存储目录的空间大小，单位为字节。

dfs.namenode.resource.checked.volumes

　

本地目录列表。

dfs.namenode.resource.checked.volumes.minimum

1

所需的冗余namenode存储卷的最小数量。 

dfs.datanode.balance.bandwidthPerSec

10m

datanode的最大带宽，可以使用如下后缀k(kilo)， m(mega)， g(giga)， t(tera)，p(peta)， e(exa)，例如128k, 512m, 1g等。或者提供完整的字节数，如134217728。

dfs.hosts

　

命名一个文件，该文件包含允许连接到namenode的主机列表。必须指定文件的完整路径名。如果值为空，则允许所有主机。

dfs.hosts.exclude

　

命名一个文件，该文件包含不允许连接到namenode的主机列表。必须指定文件的完整路径名。如果值为空，则不排除任何主机。 

dfs.namenode.max.objects

0

DFS支持的文件、目录和块的最大数量。0的值指示DFS支持的对象数目没有限制。

dfs.namenode.datanode.registration.ip-hostname-check

TRUE

当为true时，namenode连接datanode的地址必须解析成主机名。

dfs.namenode.decommission.interval

30

namenode定期检查维护是否结束的时间间隔，单位是秒。

dfs.namenode.decommission.blocks.per.interval

500000

在每次维护期间，处理块的近似数量。

dfs.namenode.decommission.max.concurrent.tracked.nodes

100

同时进入decommisson或maintenance的datanode的数量。

dfs.namenode.replication.interval

3

namenode定期计算datanode副本数量的时间间隔，单位为秒。

dfs.namenode.accesstime.precision

3600000

HDFS文件访问时间的精确值，默认为1小时。当为0时，表示禁用。

dfs.datanode.plugins

　

逗号分隔的datanode插件列表。

dfs.namenode.plugins

　

逗号分隔的namenode插件列表。

dfs.namenode.block-placement-policy.default.prefer-local-node

TRUE

控制默认块放置策略如何放置块的第一个副本。当TRUE时，它将更喜欢客户端正在运行的节点。当FALSE时，它将首选与客户端相同的机架中的节点。设置为FALSE避免了大文件的整个副本终止在单个节点上的情况，从而创建热点。

dfs.stream-buffer-size

4096

流文件的缓冲区大小。

dfs.bytes-per-checksum

512

每个校验和的字节数，不能大于dfs.stream-buffer-size属性的值。

dfs.client-write-packet-size

65536

客户端写入的数据包大小。

dfs.client.write.exclude.nodes.cache.expiry.interval.millis

600000

在客户机中排除DN列表中的DN的最大周期。在此阶段之后，以毫秒为单位，先前排除的节点将自动从缓存中移除，并且将再次被认为适合于块分配。在保持文件打开很长时间（如写前日志（WAL）文件）的情况下，可以使其降低或提高，从而使作者能够容忍集群维护重新启动。默认为10分钟。 

dfs.namenode.checkpoint.dir

file://${hadoop.tmp.dir}/dfs/namesecondary

DFS secondary name node存放临时镜像的目录。如果这是一个逗号分隔的目录列表，则在所有目录中复制该图像以进行冗余。

dfs.namenode.checkpoint.edits.dir

${dfs.namenode.checkpoint.dir}

DFS secondary name node存放临时edits的目录。如果这是一个逗号分隔的目录列表，则在所有目录中复制该图像以进行冗余。

dfs.namenode.checkpoint.period

3600

两个周期检查点之间的秒数。 

dfs.namenode.checkpoint.txns

1000000

创建检查点的时间间隔。

dfs.namenode.checkpoint.check.period

60

查询未检查的检查点事务的执行时间间隔，单位为秒。

dfs.namenode.checkpoint.max-retries

3

当加载fsimage或重演edits失败时，重试的次数。

dfs.namenode.num.checkpoints.retained

2

在namenode和seccondary namenode中保留image检查点（fsimage_*）的数量。

dfs.namenode.num.extra.edits.retained

1000000

namenode的需要保留的额外的事务。

dfs.namenode.max.extra.edits.segments.retained

10000

额外的edit日志段的最大数量。

dfs.namenode.delegation.key.update-interval

86400000

namenode中更新委托令牌主密钥的时间间隔，单位为毫秒。

dfs.namenode.delegation.token.max-lifetime

604800000

令牌的最大生命周期，单位为毫秒。

dfs.namenode.delegation.token.renew-interval

86400000

授权令牌的更新间隔以毫秒为单位。 

dfs.datanode.failed.volumes.tolerated

0

在数据阳极停止服务之前允许失败的卷的数量。默认情况下，任何卷故障都会导致datanode关闭。

dfs.image.compress

FALSE

dfs image是否应该补充压缩。

dfs.image.compression.codec

org.apache.hadoop.io.compress.DefaultCodec

如果DFS图像被压缩，它们应该如何压缩？必须是 io.compression.codecs属性中定义的编解码器。

dfs.image.transfer.timeout

60000

image传输超时时间，单位为毫秒。

dfs.image.transfer.bandwidthPerSec

0

用于常规image传输的最大带宽，即每秒的字节数。

dfs.image.transfer-bootstrap-standby.bandwidthPerSec

0

从image传输到bootstrap的最大带宽。

dfs.image.transfer.chunksize

65536

上传检查点的块大小，以字节为单位。

dfs.namenode.support.allow.format

TRUE

是否允许namenode将自身进行格式化。建议设置为false。

dfs.datanode.max.transfer.threads

4096

datanode进行传输数据的最大线程数。

dfs.datanode.scan.period.hours

504

当为正值时，datanode将按照设定时间间隔进行块扫描。当为负值时，则禁止块扫描。当为0时，则使用默认的504小时（3周）进行定期扫描。

dfs.block.scanner.volume.bytes.per.second

1048576

当为0时，datanode的块扫描会被禁用，当为正数时，该属性为datanode每秒扫描的字节数。I

dfs.datanode.readahead.bytes

4194304

在读取块文件时，如果Hadoop本地库可用，datanode可以使用posix_fadvise系统调用来在当前阅读器位置之前将数据显式地写入操作系统缓冲区缓存中。这可以提高性能，尤其是当磁盘高度竞争时。此配置指定当前数据读取位置前面的字节数，datanode将尝试提前读取。通过将此属性配置为0，可以禁用此特性。如果本地库不可用，此配置没有效果。

dfs.datanode.drop.cache.behind.reads

FALSE

在一些工作负载中，从HDFS读取的数据被认为足够大以至于在操作系统缓冲区高速缓存中不太有用。在这种情况下，datanode可以被配置为在传送到客户端之后从缓存高速缓存中自动清除所有数据。对于只读取短块（例如Hbase random IO工作负载）的工作负载，此行为被自动禁用。这可以通过释放缓存缓存空间使用更多可缓存数据来改善某些工作负载的性能。如果Hadoop本机库不可用，此配置没有效果。

dfs.datanode.drop.cache.behind.writes

FALSE

在一些工作负载中，已知写入HDFS的数据足够大，以至于在操作系统缓冲区高速缓存中不太有用。在这种情况下，datanode可以被配置为在写入到磁盘之后从缓存高速缓存中自动清除所有数据。这可以通过释放缓存缓存空间使用更多可缓存数据来改善某些工作负载的性能。如果Hadoop本机库不可用，此配置没有效果。 

dfs.datanode.sync.behind.writes

FALSE

当为true时，datanode将指示操作系统在写入后立即将所有写入的数据排队到磁盘。这与通常的OS策略不同，它可能在触发写回之前等待30秒。这可以通过平滑写入磁盘的数据的IO配置文件来改善某些工作负载的性能。如果Hadoop本机库不可用，此配置没有效果。 

dfs.client.failover.max.attempts

15

client最多尝试次数，如果超过，则认为client失败。

dfs.client.failover.sleep.base.millis

500

错误重试的时间间隔，这是一个这是迄今为止尝试的数目的函数，具有\+/\- 50%的随机因子。此选项指定在故障转移计算中使用的基值。第一次故障转移将立即重试。第二次故障转移尝试将至少延迟dfs.client.failover.sleep.base.millis milliseconds，等等。

dfs.client.failover.sleep.max.millis

15000

错误重试的时间间隔，这是一个这是迄今为止尝试的数目的函数，具有\+/\- 50%的随机因子。此选项指定在故障转移之间等待的最大值dfs.client.failover.sleep.max.millis milliseconds属性值的+/- 50%。

dfs.client.failover.connection.retries

0

指示故障转移IPC客户端将建立服务器连接的重试次数。 

dfs.client.failover.connection.retries.on.timeouts

0

在建立服务器连接时，故障转移IPC客户端将在套接字超时上进行重试次数。 

dfs.client.datanode-restart.timeout

30

datanode重启等待时间，单位为秒。

dfs.nameservices

　

逗号分隔的名称服务器列表。

dfs.nameservice.id

　

nameservice的ID。

dfs.internal.nameservices

　

逗号分隔的属于集群的nameservice列表。

dfs.ha.namenodes.EXAMPLENAMESERVICE

　

给定nameservicce的前缀列表，可以用逗号分隔。这将被用于确定集群中中的namenode。

dfs.ha.namenode.id

　

namenode的ID。

dfs.ha.log-roll.period

120

standby节点向active节点询问edits的时间间隔，以秒为单位。

dfs.ha.tail-edits.period

60

standby节点检查log段的时间间隔，以秒为单位。

dfs.ha.tail-edits.rolledits.timeout

60

在active namenode上调用rollEdits RPC的超时时间，单位为秒。

dfs.ha.automatic-failover.enabled

FALSE

是否启用自动故障转移。

dfs.client.use.datanode.hostname

FALSE

client连接datanode时，是否应该使用datanode的主机名。

dfs.datanode.use.datanode.hostname

FALSE

datanode连接其它datanode进行数据传输时，是否应该使用datanode的主机名。

dfs.client.local.interfaces

　

一个逗号分隔的网络接口名称列表，用于client和datanode之间的数据传输。

dfs.datanode.shared.file.descriptor.paths

/dev/shm,/tmp

一个逗号分隔的路径列表，用于创建将在datanode和client之间共享的文件描述符。

dfs.short.circuit.shared.memory.watcher.interrupt.check.ms

60000

为单元测试使用的一个属性。

dfs.namenode.kerberos.principal

　

namenode服务主体。这通常设置为nn/\_HOST@REALM.TLD。每个namenode将在启动时用它自己的完全限定主机名替换宿主。 \_HOST占位符允许在HA设置中使用两个namenode上相同的配置设置。

dfs.namenode.keytab.file

　

namenode服务主体的keytab文件，主体参数由dfs.namenode.kerberos.principal属性配置。

dfs.datanode.kerberos.principal

　

datanode服务主体。

dfs.datanode.keytab.file

　

datanode服务主体的keytab文件，主体参数由dfs.datanode.kerberos.principal属性配置。

dfs.journalnode.kerberos.principal

　

JournalNode服务主体。这通常设置为jn/\_HOST@REALM.TLD。每个journalnode将在启动时用它自己的完全限定主机名替换宿主。 \_HOST占位符允许使用与其它journalnode相同的配置设置。

dfs.journalnode.keytab.file

　

journalnode服务主体的keytab文件，主体参数由dfs.journalnode.kerberos.principal属性配置。

dfs.namenode.kerberos.internal.spnego.principal

${dfs.web.authentication.kerberos.principal}

当kerberos启用时，namenode用于web UI SPNEGO验证的服务主体。

dfs.journalnode.kerberos.internal.spnego.principal

　

当kerberos启用时，journalnode http server用于SPNEGO验证的服务主体。

dfs.secondary.namenode.kerberos.internal.spnego.principal

${dfs.web.authentication.kerberos.principal}

当kerberos启用时，secondary namenode用于web UI SPNEGO验证的服务主体。

dfs.web.authentication.kerberos.principal

　

namenode用于WebHDFS SPNEGO验证的服务主体，需要WebHDFS和安全性都启用。 

dfs.web.authentication.kerberos.keytab

　

和dfs.web.authentication.kerberos.principal属性的主体相关的keytab文件。 

dfs.namenode.kerberos.principal.pattern

*

在跨域环境中使用。

dfs.namenode.avoid.read.stale.datanode

FALSE

是否允许读取“陈旧”datanode（也就是在设定时间间隔内没有向namenode发送心跳消息的节点）。

dfs.namenode.avoid.write.stale.datanode

FALSE

是否允许写入“陈旧”datanode（也就是在设定时间间隔内没有向namenode发送心跳消息的节点）。

dfs.namenode.stale.datanode.interval

30000

在设定的这个时间里，如果namenode没有收到datanode的心跳消息，则将datanode置为“陈旧”datanode，单位为毫秒。

dfs.namenode.write.stale.datanode.ratio

0.5f

当陈旧datanode的数量占比超过设置的值时，会停止写入陈旧的datanode。

dfs.namenode.invalidate.work.pct.per.iteration

0.32f

注意：高级属性。谨慎改变。该属性决定了单条datanode心跳删除命令进行块无效（删除）的百分比。0.32f表示100%。

dfs.namenode.replication.work.multiplier.per.iteration

2

注意：高级属性。谨慎改变。Datanode并行传输时的块数量。这个数字可以是任何正、非零整数。

nfs.server.port

2049

nft的端口号。

nfs.mountd.port

4242

hadoop安装守护进程的端口号。

nfs.dump.dir

/tmp/.hdfs-nfs

该目录用于在写入HDFS之前临时保存无序的写入。对于每一个文件，无序的写入在累积到超过一定的阈值（例如1MB）之后被丢弃，因此需要确保目录有足够的空间。

nfs.rtmax

1048576

这是NFS网关支持的读取请求的最大字节大小。

nfs.wtmax

1048576

 这是NFS网关支持的写入请求的最大字节大小。

nfs.keytab.file

　

注意：高级属性。谨慎改变。这是HDFS NFS网关的keytab文件的路径。

nfs.kerberos.principal

　

注意：高级属性。谨慎改变。这是Kerberos主体的名称。格式为nfs-gateway-user/nfs-gateway-host@kerberos-realm

nfs.allow.insecure.ports

TRUE

当为false时，会拒绝来自无特权端口（高于1023的端口）的客户端连接。

dfs.webhdfs.enabled

TRUE

是否允许在namenode和datanode中启用WebHDFS (REST API)。

hadoop.fuse.connection.timeout

300

在fuse_dfs中缓存libhdfs连接对象的最小秒数。较低的值将导致较低的内存消耗；较高的值可以通过避免创建新连接对象的开销来加快访问速度。 

hadoop.fuse.timer.period

5

fuse_dfs中缓存过期检查之间的秒数。

dfs.namenode.metrics.logger.period.seconds

600

namenode记录其度量的频率。

dfs.datanode.metrics.logger.period.seconds

600

datanode记录其度量的频率。

dfs.metrics.percentiles.intervals

　

默认情况下被禁用。

dfs.datanode.peer.stats.enabled

FALSE

是否开启datanode的跟踪统计。

dfs.datanode.outliers.report.interval

1800000

控制datanode报告对等延迟的频率。

dfs.datanode.fileio.profiling.sampling.percentage

0

设置控制文件I/O事件的百分比。默认值为0禁用磁盘统计。设置为1和100之间的整数值，以启用磁盘统计。

hadoop.user.group.metrics.percentiles.intervals

　

默认情况下被禁用。

dfs.encrypt.data.transfer

FALSE

是否启用块数据的加密。

dfs.encrypt.data.transfer.algorithm

　

选项有3des和rc4两种。

dfs.encrypt.data.transfer.cipher.suites

　

选项有AES/CTR/NoPadding及未定义四种。

dfs.encrypt.data.transfer.cipher.key.bitlength

128

client和datanode之间的密钥位长度，值有128，192和256三种。

dfs.trustedchannel.resolver.class

　

TrustedChannelResolver用于确定通道是否受信任以用于普通数据传输。

dfs.data.transfer.protection

　

一个逗号分隔的SASL保护值列表，用于读取或写入块数据时与datanode的安全连接。选项有authentication, integrity and privacy三种。

dfs.data.transfer.saslproperties.resolver.class

　

用于连接datanode的QOP的SaslPropertiesResolver，默认是hadoop.security.saslproperties.resolver.class。

dfs.datanode.hdfs-blocks-metadata.enabled

FALSE

是否启用后面datanode支持DistributedFileSystem#getFileVBlockStorageLocations API。

dfs.client.file-block-storage-locations.num-threads

10

DistributedFileSystem#getFileBlockStorageLocations()中进行并行RPC的线程数。

dfs.client.file-block-storage-locations.timeout.millis

1000

DistributedFileSystem#getFileBlockStorageLocations()中进行RPC的超时时间，单位为毫秒。

dfs.journalnode.rpc-address

0.0.0.0:8485

JournalNode RPC服务器地址和端口。

dfs.journalnode.http-address

0.0.0.0:8480

JournalNode HTTP服务器监听的地址和端口。如果端口为0，那么服务器将在自由端口启动。

dfs.journalnode.https-address

0.0.0.0:8481

JournalNode HTTPS服务器监听的地址和端口。如果端口为0，那么服务器将在自由端口启动。

dfs.namenode.audit.loggers

default

org.apache.hadoop.hdfs.server.namenode.AuditLogger的实现类。

dfs.datanode.available-space-volume-choosing-policy.balanced-space-threshold

10737418240

当dfs.datanode.fsdataset.volume.choosing.policy属性设置为org.apache.hadoop.hdfs.server.datanode.fsdataset.AvailableSpaceVolumeChoosingPolicy时使用。该属性控制datanode卷在被认为不平衡之前允许在空闲磁盘空间上有多少不同字节。如果所有卷的自由空间都在这一范围内，则卷将被认为是平衡的，并且块分配将在纯循环的基础上完成。

dfs.datanode.available-space-volume-choosing-policy.balanced-space-preference-fraction

0.75f

当dfs.datanode.fsdataset.volume.choosing.policy属性设置为org.apache.hadoop.hdfs.server.datanode.fsdataset.AvailableSpaceVolumeChoosingPolicy时使用。此属性控制新的块分配百分比将被发送给具有比其他磁盘更可用的磁盘空间的卷。这个设置应该在0.0到1.0的范围内。

dfs.namenode.edits.noeditlogchannelflush

FALSE

是否刷新edit log文件通道。

dfs.client.cache.drop.behind.writes

　

与dfs.datanode.drop.cache.behind.writes属性类似，该属性导致页面缓存被丢弃在HDFS写之后，可能释放更多的内存用于其他用途。

dfs.client.cache.drop.behind.reads

　

与dfs.datanode.drop.cache.behind.reads属性类似，该属性导致页面缓存被丢弃在HDFS读取之后，可能释放更多的内存用于其他用途。

dfs.client.cache.readahead

　

当使用远程读取时，此设置会导致datanode使用posix_fadvise在块文件中提前读取，可能会降低I/O等待时间。

dfs.namenode.enable.retrycache

TRUE

当为true时，允许在namenode上重试缓存。

dfs.namenode.retrycache.expirytime.millis

600000

重试缓存条目被保留的时间。

dfs.namenode.retrycache.heap.percent

0.03f

此参数配置为重试缓存分配的堆大小（不包括响应缓存）。

dfs.client.mmap.enabled

TRUE

如果将此设置为false，客户端将不会尝试内存映射读取。

dfs.client.mmap.cache.size

256

当使用0拷贝读取时，DFS client保持最近使用的内存映射区域的缓存。此参数控制将在该缓存中保留的最大条目数。这个数字越大，我们可能会使用更多的内存描述符文件描述符。注意，当这个大小设置为0时，仍然可以进行零拷贝读取。 Wh

dfs.client.mmap.cache.timeout.ms

3600000

在使用时，我们将在缓存中保持MMAP条目的最小时间长度。如果一个条目在缓存中比这个长，并且没有人使用它，它将被后台线程移除。

dfs.client.mmap.retry.timeout.ms

300000

在重试失败的MMAP操作之前，我们将等待的最小时间量。

dfs.client.short.circuit.replica.stale.threshold.ms

1800000

如果没有datanode的通信，我们将考虑短路副本的有效时间是最大的。经过这段时间后，即使在缓存中，我们也会重新获取短路副本。

dfs.namenode.path.based.cache.block.map.allocation.percent

0.25

分配给缓存块地图的java堆的百分比。

dfs.datanode.max.locked.memory

0

用于在datanode上缓存块副本的字节内存量。

dfs.namenode.list.cache.directives.num.responses

100

设置NAMENODE将响应于listDirectives RPC发送的高速缓存指令的数量。.

dfs.namenode.list.cache.pools.num.responses

100

设置NAMENODE将响应于listPools RPC发送的高速缓存池的数量。

dfs.namenode.path.based.cache.refresh.interval.ms

30000

后续路径高速缓存之间的毫秒数。

dfs.namenode.path.based.cache.retry.interval.ms

30000

当NAMENODE需要取消缓存的东西，或者缓存未缓存的东西时，它必须通过发送 DNA\_CACHE或DNA\_UNCACHE命令来响应数据阳极心跳来引导数据。

dfs.datanode.fsdatasetcache.max.threads.per.volume

4

用于缓存datanode上新数据的每卷的最大线程数。这些线程同时消耗I/O和CPU。这会影响正常的datanode操作。

dfs.cachereport.intervalMsec

10000

以毫秒为单位确定缓存报告间隔。在这段时间之后，datanode将其缓存状态的完整报告发送到namenode。

dfs.namenode.edit.log.autoroll.multiplier.threshold

2

确定active namenode何时滚动自己的edit log。

dfs.namenode.edit.log.autoroll.check.interval.ms

300000

active namenode以毫秒为单位检查它是否需要滚动自己的edit log。

dfs.webhdfs.user.provider.user.pattern

^\[A-Za-z_\]\[A-Za-z0-9._-\]*\[$\]?$

webhdfs用户名和组的有效模式，它必须是一个有效的java正则表达式。 

dfs.webhdfs.acl.provider.permission.pattern

^(default:)?(user|group|mask|other):\[\[A-Za-z_\]\[A-Za-z0-9._-\]\]*:(\[rwx-\]{3})?(,(default:)?(user|group|mask|other):\[\[A-Za-z_\]\[A-Za-z0-9._-\]\]*:(\[rwx-\]{3})?)*$

在webhdfs ACL操作的用户和组名的有效模式，它必须是一个有效的java正则表达式。

dfs.webhdfs.socket.connect-timeout

60s

连接到WebHDFS服务器的Socket超时时间。

dfs.webhdfs.socket.read-timeout

60s

从WebHDFS服务器读取数据的套接字超时时间。单位可以为 ns, us, ms, s, m, h, d for nanoseconds, microseconds, milliseconds, seconds, minutes, hours, days 等。

dfs.client.context

default

我们应该使用的DFSClient上下文的名称。

dfs.client.read.shortcircuit

FALSE

此配置参数开启短路本地读取。 

dfs.client.socket.send.buffer.size

0

DFSClient的套接字发送缓冲区大小。这可能影响TCP连接吞吐量。如果设置为零或负值，则不显式设置缓冲区大小，从而使TCP自动调整到某些系统上。默认值为0。.

dfs.domain.socket.path

　

可选项。DataNode 本地文件系统到 UNIX 域套接字的路径，用于 DataNode 和本地 HDFS 客户端之间的通信。该套接字用于 Short Circuit Read。只有 HDFS 系统用户和“root”拥有父目录及其所有上级的写入权限。

dfs.client.read.shortcircuit.skip.checksum

FALSE

如果设置了此配置参数，则短路本地读取将跳过校验和。这通常是不推荐的，但它可能对特殊设置有用。如果正在HDFS之外进行自己的校验求和，则可以考虑使用此方法。 

dfs.client.read.shortcircuit.streams.cache.size

256

DFS客户端维护了一个最近打开的文件描述符的缓存，这个参数控制缓存中文件描述符的最大数量。

dfs.client.read.shortcircuit.streams.cache.expiry.ms

300000

控制文件描述符在client缓存中的最小时间。

dfs.datanode.shared.file.descriptor.paths

/dev/shm,/tmp

创建共享内存段的目录，用逗号分隔。Client和datanode通过这个共享内存段交换信息。

dfs.namenode.audit.log.debug.cmdlist

　

当audit log级别是debug时，写入到namenode audit log的命令列表，用逗号分隔。

dfs.client.use.legacy.blockreader.local

FALSE

当为true时，使用基于HDFS-2246的 Legacy short-circuit reader实现方式。

dfs.block.local-path-access.user

　

允许在legacy short-circuit本地读取时打开块文件的用户列表，用逗号分隔。

dfs.client.domain.socket.data.traffic

FALSE

控制是否会尝试通过UNIX域套接字传递正常的数据流量，而不是通过TCP套接字在节点本地数据传输上传递数据。

dfs.namenode.reject-unresolved-dn-topology-mapping

FALSE

当为true时，如果datanode的拓扑映射未被解析并且返回null，则namenode将拒绝此datanode的注册。

dfs.client.slow.io.warning.threshold.ms

30000

在dfsclient中记录慢io警告的阈值。

dfs.datanode.slow.io.warning.threshold.ms

300

在datanode中记录慢io警告的阈值。

dfs.namenode.xattrs.enabled

TRUE

是否支持扩展namenode的属性。

dfs.namenode.fs-limits.max-xattrs-per-inode

32

每个索引节点的扩展属性的最大数目。

dfs.namenode.fs-limits.max-xattr-size

16384

以字节为单位的扩展属性的名称和值的最大组合大小。它应该大于0，小于或等于32768。

dfs.namenode.lease-recheck-interval-ms

2000

　

dfs.namenode.max-lock-hold-to-release-lease-ms

25

在释放lease期间，锁会使NAMENODE上的任何操作卡住。

dfs.namenode.write-lock-reporting-threshold-ms

5000

当一个写锁在NAMENODE上被保存很长时间时，当锁被释放时，这将被记录下来。这设置了日志记录发生时必须持有锁的时间。

dfs.namenode.read-lock-reporting-threshold-ms

5000

当读锁在NAMENODE上保存很长时间时，当锁被释放时将记录该日志。这设置了日志记录发生时必须持有锁的时间。

dfs.namenode.lock.detailed-metrics.enabled

FALSE

如果为true，NAMENODE将跟踪各种操作保存命名空间锁的时间，并将其作为度量。

dfs.namenode.fslock.fair

TRUE

如果为true，FS namesystem锁将在公平模式下使用，这将有助于防止编写器线程被饿死，但可以提供更低的锁定吞吐量。

dfs.namenode.startup.delay.block.deletion.sec

0

在NAMENODE启动后，延迟设定时间后，我们将暂停块删除。默认情况下，它已被禁用。

dfs.namenode.list.encryption.zones.num.responses

100

当列出加密区域时，将在批处理中返回的最大区域数。

dfs.namenode.list.openfiles.num.responses

1000

当列出打开的文件时，将在单个批处理中返回的最大打开文件数。

dfs.namenode.edekcacheloader.interval.ms

1000

当KeyProvider配置后，namenode被启动或变成active时，进行edek 缓存预热的时间间隔。

dfs.namenode.edekcacheloader.initial.delay.ms

3000

当KeyProvider配置后， namenode被启动或变成active时，第一次尝试edit cache缓存预热的延迟时间。

dfs.namenode.inotify.max.events.per.rpc

1000

将在单个RPC响应中发送给客户端的最大事件数。

dfs.user.home.dir.prefix

/user

该目录用于添加用户名以获得用户的home目录。

dfs.datanode.cache.revocation.timeout.ms

900000

当dfsclient读取缓存中的datanode块文件时，将跳过校验。datanode将保持块文件在缓存中，直到客户端完成。但是，如果客户端占用非常长的时间，那么datanode可能需要从缓存中逐出块文件。此属性数值控制datanode等待客户端释放其没有校验和读取的副本的时间。

dfs.datanode.cache.revocation.polling.ms

500

datanode应该多久轮询一次，看看客户端是否停止使用datanode想要取消的副本。

dfs.datanode.block.id.layout.upgrade.threads

12

创建硬链接的最大线程数。

dfs.storage.policy.enabled

TRUE

允许用户更改文件和目录的存储策略。

dfs.namenode.legacy-oiv-image.dir

　

在standby namenode和secondary namenode的检查点期间，保存fsimage的命名空间的位置。

dfs.namenode.top.enabled

TRUE

启用nntop

dfs.namenode.top.window.num.buckets

10

nntop的桶数。

dfs.namenode.top.num.users

10

顶部工具返回的顶级用户数。

dfs.namenode.top.windows.minutes

1,5,25

nntop在分钟内的报告周期，用逗号分隔。

dfs.webhdfs.ugi.expire.after.access

600000

在最后一次访问之后，缓存的UGI将在多长时间内过期。0表示永不过期。

dfs.namenode.blocks.per.postponedblocks.rescan

10000

在postponedMisreplicatedBlocks每个迭代中扫描的块数。

dfs.datanode.block-pinning.enabled

FALSE

PIN块是否在受欢迎的datanode上。

dfs.client.block.write.locateFollowingBlock.initial.delay.ms

400

locateFollowingBlock的初始延迟，每个重试的延迟时间将成倍增加。

dfs.ha.zkfc.nn.http.timeout.ms

20000

当DFS ZKFC在本地namenode成为服务不正常后，尝试获得本地namenode线程转储时，HTTP连接和读取超时值（单位为MS）。

dfs.namenode.quota.init-threads

4

quota初始化并发线程的数量。

dfs.datanode.transfer.socket.send.buffer.size

0

DataXceiver Socket发送缓冲区大小。

dfs.datanode.transfer.socket.recv.buffer.size

0

DataXceiver Socket接收缓冲区大小。

dfs.namenode.upgrade.domain.factor

${dfs.replication}

只有当将块放置策略设置为BlockPlacementPolicyWithUpgradeDomain时，才有效。它定义了任何块的副本应该具有的唯一升级域的数量。当副本的数量小于或等于该值时，策略确保每个副本具有唯一的升级域。当副本的数量大于该值时，策略确保唯一域的数量至少为该值。 

dfs.ha.zkfc.port

8019

ZKFC的RPC端口。

dfs.datanode.bp-ready.timeout

20

在接收到的请求失败之前，datanode的最大等待时间准备就绪。

dfs.datanode.cached-dfsused.check.interval.ms

600000

在每个卷中加载DU\_CACHE\_FILE的间隔检查时间。

dfs.webhdfs.rest-csrf.enabled

FALSE

如果为真，则允许WebHDFS对跨站点请求伪造（CSRF）进行保护。

dfs.webhdfs.rest-csrf.custom-header

X-XSRF-HEADER

当 dfs.webhdfs.rest-csrf.enabled属性为true时，发送的HTTP请求的custom header。

dfs.webhdfs.rest-csrf.methods-to-ignore

GET,OPTIONS,HEAD,TRACE

当dfs.webhdfs.rest-csrf.enabled属性为true时，HTTP请求中不需要custom header的列表，用逗号分隔。

dfs.webhdfs.rest-csrf.browser-useragents-regex

^Mozilla.*,^Opera.*

当dfs.webhdfs.reset-csrf.enabled属性为true时，HTTP请求的用户代理头部需匹配的正则表达式。

dfs.xframe.enabled

TRUE

当为true时，则通过将返回的X\_FRAME\_OPTIONS设置为SAMEORIGIN，来实现对点击劫持的保护。

dfs.xframe.value

SAMEORIGIN

选项有三个：DENY/SAMEORIGIN/ALLOW-FROM。

dfs.http.client.retry.policy.enabled

FALSE

当为true时，允许WebHDFS客户端的重试策略。当WebHDFS需要在集群间拷贝超大文件，此策略非常有用。

dfs.http.client.retry.policy.spec

10000,6,60000,10

指定WebHDFS客户端的多线性随机重试策略，例如给定重试次数和睡眠时间（N0，T0），（N1，T1），…，重试N0次后睡眠T0毫秒，重试N1次后睡眠T1毫秒，等等。

dfs.http.client.failover.max.attempts

15

指定WebHDFS客户端在网络异常情况下的故障转移尝试的最大数目。 

dfs.http.client.retry.max.attempts

10

指定WebHDFS客户端重试尝试的最大次数。

dfs.http.client.failover.sleep.base.millis

500

WebHDFS客户端在重试或故障转移之间的指数增加的睡眠时间，单位为毫秒。 

dfs.http.client.failover.sleep.max.millis

15000

在WebHDFS客户端重试或故障转移之间指定睡眠时间的上限，单位为毫秒。

dfs.namenode.hosts.provider.classname

org.apache.hadoop.hdfs.server.blockmanagement.HostFileManager

提供主机文件访问的类。

datanode.https.port

50475

datanode的HTTPS端口。

dfs.balancer.dispatcherThreads

200

用于HDFS均衡器块移动器的线程池的大小。

dfs.balancer.movedWinWidth

5400000

HDFS平衡器跟踪块及其位置的时间窗口，单位是毫秒。

dfs.balancer.moverThreads

1000

用于执行块移动的线程池大小。

dfs.balancer.max-size-to-move

10737418240

在单个线程中平衡器可以移动的最大字节数。

dfs.balancer.getBlocks.min-block-size

10485760

在获取源块列表时忽略字节的最小块阈值大小。

dfs.balancer.getBlocks.size

2147483648

获取源块列表时获得的datanode块的总字节大小。

dfs.balancer.block-move.timeout

0

块移动所需的最大毫秒时间。在典型的集群中，3到5分钟的超时是合理的。如果大量的块移动发生超时，这需要增加。

dfs.balancer.max-no-move-interval

60000

如果在指定的这个时间内，没有将块从datanode中移出，则在平衡器迭代中，将更大努力投入于datanode的块移出中来。

dfs.block.invalidate.limit

1000

由NAMENODE发送到每个心跳删除命令的datanode的无效块的最大数目。

dfs.block.misreplication.processing.limit

10000

初始化复制队列所需处理的最大块数。

dfs.block.replicator.classname

org.apache.hadoop.hdfs.server.blockmanagement.BlockPlacementPolicyDefault

表示 non-striped的块放置策略的类。选项有：BlockPlacementPolicyDefault、 BlockPlacementPolicyWithNodeGroup、BlockPlacementPolicyRackFaultTolerant、BlockPlacementPolicyWithUpgradeDomain.。

dfs.blockreport.incremental.intervalMsec

0

从datanode向namenode发送增量块报告的等待时间，单位为毫秒。

dfs.checksum.type

CRC32C

校验和类型 。

dfs.client.block.write.locateFollowingBlock.retries

5

在HDFS中查找下一个块时使用的重试次数。

dfs.client.failover.proxy.provider

　

为主机配置的故障转移代理提供程序的类名的前缀（加上所需的名称服务ID）。

dfs.client.key.provider.cache.expiry

864000000

DFS客户端安全密钥缓存过期时间，以毫秒为单位。

dfs.client.max.block.acquire.failures

3

试图从指定的datanode获取块信息时允许出现的最多错误数。

dfs.client.read.prefetch.size

　

DFS客户端在读操作时每次从namenode读取的字节数。默认值是dfs.blocksize属性值的10倍。 

dfs.client.read.short.circuit.replica.stale.threshold.ms

1800000

在 short-circuit本地读取期间，读取entries的最大阈值，单位是毫秒。

dfs.client.read.shortcircuit.buffer.size

1048576

用于本地短路读取的缓冲区大小。

dfs.client.replica.accessor.builder.classes

　

用于构建ReplicaAccessor的类，用逗号分隔。 

dfs.client.retry.interval-ms.get-last-block-length

4000

在从datanode获取块长度时，再次重试间的时间间隔，单位是毫秒。

dfs.client.retry.max.attempts

10

DFS客户端尝试与namenode会话的最大重试次数。

dfs.client.retry.policy.enabled

FALSE

当为true时，则开启DFS客户端的重试策略。

dfs.client.retry.policy.spec

10000,6,60000,10

DFS客户端的超时时间和重试次数的数值对。

dfs.client.retry.times.get-last-block-length

3

调用fetchLocatedBlocksAndGetLastBlockLength()的最大重试次数。

dfs.client.retry.window.base

3000

用于DFS客户端重试的MS的基本时间窗口。对于每个重试尝试，该值线性扩展（例如，第一次尝试3000毫秒，第二次重试6000毫秒，第三次重试9000毫秒等）。

dfs.client.socket-timeout

60000

所有socket的默认超时时间，单位为毫秒。

dfs.client.socketcache.capacity

16

用于短路读取的socket缓存容量。

dfs.client.socketcache.expiryMsec

3000

用于短路读取的socket缓存过期时间，单位为毫秒。

dfs.client.test.drop.namenode.response.number

0

每个RPC调用由DFS客户端删除的namenode响应的数目。用于测试namenode重试缓存。

dfs.client.hedged.read.threadpool.size

0

支持DFS客户端的hedged读取。若要启用此特性，需要将参数设置为正数。

dfs.client.hedged.read.threshold.millis

500

配置DFS客户端的hedged读取。属性值为启动hedged读取前的等待时间。

dfs.client.use.legacy.blockreader

FALSE

当为true时，则本地短路读取使用RemoteBlockReader类，当为false时，则使用RemoteBlockReader2类。

dfs.client.write.byte-array-manager.count-limit

2048

每个数组长度允许的最大数组数。

dfs.client.write.byte-array-manager.count-reset-time-period-ms

10000

分配每个数组长度的时间间隔，如果没有增量，则为0。

dfs.client.write.byte-array-manager.count-threshold

128

每个数组长度的计数阈值，使得只有在分配计数超过阈值后才创建管理器。

dfs.client.write.byte-array-manager.enabled

FALSE

如果为true，则启用DFSOutputStream流使用的字节数组管理器。

dfs.client.write.max-packets-in-flight

80

DFSPackets允许的最大间隔数。

dfs.content-summary.limit

5000

在一个锁定周期中允许的最大内容摘要计数。0或负数意味着没有限制。

dfs.content-summary.sleep-microsec

500

在内容汇总计算中，两次请求锁的时间。

dfs.data.transfer.client.tcpnodelay

TRUE

当为true时，则从DFS客户端传输时，设置socket为TCP_NODELAY。

dfs.datanode.balance.max.concurrent.moves

50

做balance时每个dn移动块的最大并行线程数。

dfs.datanode.fsdataset.factory

　

为datanode存储副本的基础存储的类名。默认为org.apache.hadoop.hdfs.server.datanode.fsdataset.impl.FsDatasetFactory。

dfs.datanode.fsdataset.volume.choosing.policy

　

目录列表中选择卷的策略的类名。默认为org.apache.hadoop.hdfs.server.datanode.fsdataset.RoundRobinVolumeChoosingPolicy。

dfs.datanode.hostname

　

可选的。包含此配置文件的datanode的主机名。每个机器都会不同。默认为当前主机名。

dfs.datanode.lazywriter.interval.sec

60

惰性持久化写入datanode的时间间隔。

dfs.datanode.network.counts.cache.max.size

2147483647

每个主机网络错误计数缓存的datanode可能包含的条目的最大数量。

dfs.datanode.oob.timeout-ms

1500,0,0,0

为每个OOB类型发送OOB响应时的超时值，分别为OOB\_RESTART、OOB\_RESERVED1、OOB\_RESERVED2、OOB\_RESERVED3。目前只有OOB_RESTART被用到。

dfs.datanode.parallel.volumes.load.threads.num

　

用于升级数据目录的最大线程数。默认值是datanode中存储目录的数量。

dfs.datanode.ram.disk.replica.tracker

　

实现RamDiskReplicaTracker接口的类的名称。默认为org.apache.hadoop.hdfs.server.datanode.fsdataset.impl.RamDiskReplicaLruTracker。

dfs.datanode.restart.replica.expiration

50

在重新启动关机期间，为datanode重新启动的预算时间，单位为秒。

dfs.datanode.socket.reuse.keepalive

4000

在DataXceiver关闭单个请求的套接字之间的时间窗口。如果在该窗口内出现第二个请求，则可以重新使用套接字。

dfs.datanode.socket.write.timeout

480000

写入danode的客户端socket超时时间，单位为毫秒。

dfs.datanode.sync.behind.writes.in.background

FALSE

如果设置为true，那么sync\_file\_range()系统调用将异步发生。

dfs.datanode.transferTo.allowed

TRUE

当为false时，则在32位机器上，将大于等于2GB的块分成较小的块。

dfs.ha.fencing.methods

　

在故障转移期间，用于激活namenode的脚本或类名列表。

dfs.ha.standby.checkpoints

TRUE

如果为true，则在待机状态下的NAMENODE周期性地采取命名空间的检查点，将其保存到本地存储，然后上载到远程NAMENODE。

dfs.ha.zkfc.port

8019

zookeeper故障转移控制器RPC服务器绑定的端口号。

dfs.http.port

　

Hftp、HttpFS、WebHdfs的http端口。

dfs.https.port

　

Hftp、HttpFS、WebHdfs的https端口。

dfs.journalnode.edits.dir

/tmp/hadoop/dfs/journalnode/

存储 journal edit文件的目录。

dfs.journalnode.kerberos.internal.spnego.principal

　

journal节点使用的Kerberos SPNEGO主体名称。

dfs.journalnode.kerberos.principal

　

journal节点使用的Kerberos主体名称。

dfs.journalnode.keytab.file

　

journal节点keytab文件。

dfs.ls.limit

1000

限制ls打印的文件数。如果小于或等于零，最多将打印 DFS\_LIST\_LIMIT_DEFAULT (= 1000)。

dfs.mover.movedWinWidth

5400000

一个块可以再次移动到另一个位置的最小时间间隔，以毫秒为单位。

dfs.mover.moverThreads

1000

配置均衡器的移动线程池大小。 

dfs.mover.retry.max.attempts

10

在移动者认为移动失败之前重试的最大次数。 

dfs.mover.max-no-move-interval

60000

如果指定的时间量已经过去，并且没有块已经从源datanode中移出，则将更加努力地将块移到当前MOVER迭代中的该datanode之外。

dfs.namenode.audit.log.async

FALSE

如果为true，启用异步审计日志。

dfs.namenode.audit.log.token.tracking.id

FALSE

如果为true，则为所有审计日志事件添加跟踪ID。 

dfs.namenode.available-space-block-placement-policy.balanced-space-preference-fraction

0.6

只有当dfs.block.replicator.classname设置为org.apache.hadoop.hdfs.server.blockmanagement.AvailableSpaceBlockPlacementPolicy时使用。值在0和1之间。

dfs.namenode.backup.dnrpc-address

　

用于备份NAMENODE的服务RPC地址。

dfs.namenode.delegation.token.always-use

FALSE

用于测试。设置为TRUE时总是允许使用DT秘密管理器，即使安全被禁用。

dfs.namenode.edits.asynclogging

TRUE

如果设置为true，则启用NAMENODE中的异步编辑日志。如果设置为false，NAMENODE使用传统的同步编辑日志。

dfs.namenode.edits.dir.minimum

1

dfs.namenode.edits.dir同时需要的目录。

dfs.namenode.edits.journal-plugin

　

当FSEditLog正在从dfs.namenode.edits.dir创建日记管理器时，它遇到一个与“文件”不同的模式的URI，它从“dfs.namenode.edits.journal-plugin.\[schema\]”中加载实现类的名称。这个类必须实现日志管理器，并有一个构造函数。

dfs.namenode.file.close.num-committed-allowed

0

通常，只能当所有块都提交后，才能关闭文件。当该值设置为正整数N时，当N个块被提交并且其余部分完成时，文件可以被关闭。 

dfs.namenode.inode.attributes.provider.class

　

用于委派HDFS授权的类的名称。

dfs.namenode.inode.attributes.provider.bypass.users

　

将为所有操作绕过外部属性提供程序的用户主体或用户名的列表。

dfs.namenode.max-num-blocks-to-log

1000

对块报告后由NAMENODE打印到日志块的数量进行限制。

dfs.namenode.max.op.size

52428800

最大操作码大小，以字节为单位。

dfs.namenode.name.cache.threshold

10

经常访问的文件访问次数超过了这个阈值，缓存在FSDirectory nameCache中。

dfs.namenode.replication.max-streams

2

最高优先级复制流的数量的硬限制。 

dfs.namenode.replication.max-streams-hard-limit

4

所有复制流的硬限制。

dfs.namenode.replication.pending.timeout-sec

-1

块复制的超时秒数。如果这个值是0或更少，那么它将默认为5分钟。

dfs.namenode.stale.datanode.minimum.interval

3

用NAMENODE标记datanode的数据丢失间隔的最小次数。

dfs.namenode.snapshot.capture.openfiles

FALSE

如果为true，则获取的快照将具有具有有效租约的打开文件的不可变共享副本。即使在打开的文件增长或缩小的大小，快照总是会有以前的时间点打开文件的版本，就像所有其他封闭的文件。默认为false。

dfs.namenode.snapshot.skip.capture.accesstime-only-change

FALSE

如果文件/目录的访问时间发生了更改，但没有对文件/目录进行其他修改，则在下一个快照中不会捕获更改后的访问时间。但是，如果对文件/目录进行了其他修改，则最新的访问时间将与下一快照中的修改一起捕获。

dfs.pipeline.ecn

FALSE

如果为true，则允许来自datanode的ECN（显式拥塞通知）。

dfs.qjournal.accept-recovery.timeout.ms

120000

在特定段的恢复/同步接受阶段中的仲裁超时时间，以毫秒为单位。

dfs.qjournal.finalize-segment.timeout.ms

120000

在特定片段的最终确定过程中的仲裁超时时间，以毫秒为单位。

dfs.qjournal.get-journal-state.timeout.ms

120000

调用 getJournalState()的超时时间。

dfs.qjournal.new-epoch.timeout.ms

120000

获得对日志节点的写入访问的opoch数时的超时时间，以毫秒为单位。

dfs.qjournal.prepare-recovery.timeout.ms

120000

在特定段的恢复/同步准备阶段的仲裁超时时间，以毫秒为单位。

dfs.qjournal.queued-edits.limit.mb

10

quorum journal edits的队列大小，单位是MB。

dfs.qjournal.select-input-streams.timeout.ms

20000

从日记管理器接受流时的超时时间，以毫秒为单位。

dfs.qjournal.start-segment.timeout.ms

20000

启动日志段的超时时间，以毫秒为单位。

dfs.qjournal.write-txns.timeout.ms

20000

定稿远程journal的超时时间，以毫秒为单位。

dfs.quota.by.storage.type.enabled

TRUE

如果为true，则启用基于存储类型的配额。

dfs.secondary.namenode.kerberos.principal

　

Secondary NameNode的Kerberos主体名称。

dfs.secondary.namenode.keytab.file

　

Secondary NameNode的Kerberos keytab文件。

dfs.support.append

TRUE

启用NAMENODE上的append支持。 

dfs.web.authentication.filter

org.apache.hadoop.hdfs.web.AuthFilter

用于WebHDFS的身份验证筛选器类。 

dfs.web.authentication.simple.anonymous.allowed

　

如果为true，允许匿名用户访问WebHDFS。设置为false以禁用匿名身份验证。

dfs.web.ugi

　

dfs.web.ugi被弃用，建议用hadoop.http.staticuser.user代替。

dfs.webhdfs.netty.high.watermark

65535

Datanode WebHdfs的Netty高水印配置。

dfs.webhdfs.netty.low.watermark

32768

Datanode WebHdfs的Netty低水印配置。

dfs.webhdfs.oauth2.access.token.provider

　

使用OAuth2访问WebHDFS的令牌提供者类。默认为org.apache.hadoop.hdfs.web.oauth2.ConfCredentialBasedAccessTokenProvider。

dfs.webhdfs.oauth2.client.id

　

客户端ID，用于获取凭据或刷新令牌的访问令牌。

dfs.webhdfs.oauth2.enabled

FALSE

如果为true，则启用WebHDFS中的OAuth2 。

dfs.webhdfs.oauth2.refresh.url

　

用以获得带有凭证或刷新令牌的承载令牌的URL。

ssl.server.keystore.keypassword

　

HTTPS-SSL配置的密钥存储密钥密码。

ssl.server.keystore.location

　

HTTPS-SSL配置的密钥存储位置。

ssl.server.keystore.password

　

HTTPS-SSL配置的密钥存储密码。

dfs.balancer.keytab.enabled

FALSE

设置为true以启用Kerberized Hadoop的keytab的登录。

dfs.balancer.address

0.0.0.0:0

基于Kerberos登录时，用于keytab的主机名。

dfs.balancer.keytab.file

　

平衡器使用的keytab文件作为其服务主体登录。

dfs.balancer.kerberos.principal

　

平衡器主体，通常为balancer/_HOST@REALM.TLD。

ssl.server.truststore.location

　

HTTPS-SSL配置的信任存储位置。

ssl.server.truststore.password

　

HTTPS-SSL配置的信任存储密码。

dfs.lock.suppress.warning.interval

10s

报告长临界段的instrumentation在设置的时间间隔内，将挂起警告。

dfs.webhdfs.use.ipc.callq

TRUE

通过通过rpc调用的webhdfs路由。

httpfs.buffer.size

4096

创建或打开HTTPFS文件系统IO流时使用的缓冲区大小。

dfs.datanode.disk.check.min.gap

15m

同一datanode卷的两次连续检查之间的最小间隔。

dfs.datanode.disk.check.timeout

10m

在DataNode启动期间，磁盘检查完成的最大允许时间。如果在该时间间隔内没有完成检查，则将磁盘声明为失败。此设置支持多个时间单位后缀，如 dfs.heartbeat.interval中所描述的。如果没有指定后缀，则假设为毫秒。

dfs.use.dfs.network.topology

TRUE

启用DFSNetworkTopology选择放置副本的节点。

dfs.qjm.operations.timeout

60s

QuorumJournalManager为相关操作设置超时的公共密钥。

dfs.reformat.disabled

FALSE

禁用NAMENODE的重新格式化。

dfs.federation.router.default.nameserviceId

　

要监视的默认子集群的Nameservice标识符。

dfs.federation.router.rpc.enable

TRUE

如果为true，则启用在路由器中处理客户端请求的RPC服务。 

dfs.federation.router.rpc-address

0.0.0.0:8888

处理所有客户端请求的RPC地址。此属性的值将采用 router-host1:rpc-port端口的形式。 

dfs.federation.router.rpc-bind-host

　

RPC服务器将绑定到的实际地址。如果设置了这个可选地址，它只覆盖dfs.federation.router.rpc-address的主机名部分。

dfs.federation.router.handler.count

10

路由器用于处理来自客户端的RPC请求的服务器线程数。

dfs.federation.router.handler.queue.size

100

处理RPC客户端请求的处理数的队列大小。

dfs.federation.router.reader.count

1

路由器处理RPC客户端请求的读数。 

dfs.federation.router.reader.queue.size

100

路由器处理RPC客户端请求的读数的队列大小。

dfs.federation.router.connection.pool-size

1

从路由器到NAMENODE的连接池的大小。

dfs.federation.router.connection.clean.ms

10000

时间间隔，以毫秒为单位，检查连接池是否应该删除未使用的连接。 

dfs.federation.router.connection.pool.clean.ms

60000

时间间隔，以毫秒为单位，检查连接管理器是否应该删除未使用的连接池。 

dfs.federation.router.metrics.enable

TRUE

是否启用了路由器中的度量。 

dfs.federation.router.metrics.class

org.apache.hadoop.hdfs.server.federation.metrics.FederationRPCPerformanceMonitor

类来监视路由器中的RPC系统。它必须实现RouterRpcMonitor接口。

dfs.federation.router.admin.enable

TRUE

如果为true，则启用在路由器中处理客户端请求的RPC管理服务。

dfs.federation.router.admin-address

0.0.0.0:8111

处理管理请求的RPC地址。此属性的值将采用router-host1:rpc-port的形式。

dfs.federation.router.admin-bind-host

　

RPC管理服务器将绑定到的实际地址。如果设置了这个可选地址，它只覆盖 dfs.federation.router.admin-address地址的主机名部分。

dfs.federation.router.admin.handler.count

1

路由器的服务器线程数，以处理来自管理员的RPC请求。 

dfs.federation.router.http-address

0.0.0.0:50071

处理Web请求到路由器的HTTP地址。此属性的值将采用router-host1:http-port端口的形式。

dfs.federation.router.http-bind-host

　

HTTP服务器将绑定到的实际地址。如果设置了这个可选地址，它只覆盖dfs.federation.router.http-address地址的主机名部分。

dfs.federation.router.https-address

0.0.0.0:50072

处理Web请求到路由器的HTTPS地址。此属性的值将采用router-host1:https-port端口的形式。

dfs.federation.router.https-bind-host

　

HTTPS服务器将绑定到的实际地址。如果设置了这个可选地址，它只覆盖dfs.federation.router.https-address地址的主机名部分。

dfs.federation.router.http.enable

TRUE

是否启用了在路由器中处理客户端请求的HTTP服务。

dfs.federation.router.metrics.enable

TRUE

是否启用了路由器中的度量服务。

dfs.federation.router.file.resolver.client.class

org.apache.hadoop.hdfs.server.federation.MockResolver

文件解析为子集群的类。

dfs.federation.router.namenode.resolver.client.class

org.apache.hadoop.hdfs.server.federation.resolver.MembershipNamenodeResolver

解析子集群的NAMENODE的类。

dfs.federation.router.store.enable

TRUE

如果为TRUE，路由器连接到状态存储。

dfs.federation.router.store.serializer

org.apache.hadoop.hdfs.server.federation.store.driver.impl.StateStoreSerializerPBImpl

序列化状态存储记录的类。

dfs.federation.router.store.driver.class

org.apache.hadoop.hdfs.server.federation.store.driver.impl.StateStoreFileImpl

实现状态存储的类。默认情况下，它使用本地磁盘。

dfs.federation.router.store.connection.test

60000

在毫秒内检查连接到状态存储的频率。

dfs.federation.router.cache.ttl

60000

在毫秒内刷新状态存储缓存的频率。

dfs.federation.router.store.membership.expiration

300000

membership记录的过期时间，单位为毫秒。

dfs.federation.router.heartbeat.enable

TRUE

如果为true，路由器心跳进入状态存储。

dfs.federation.router.heartbeat.interval

5000

路由器进入状态存储的心跳频率，单位为毫秒。

dfs.federation.router.monitor.namenode

　

NAMENODE的标识符以监视和心跳。

dfs.federation.router.monitor.localnamenode.enable

TRUE

如果为true，路由器应监视本地机器中的NAMENODE。

### yarn-site.xml

参数

属性值

解释

yarn.resourcemanager.address

客户端对ResourceManager主机通过 host:port 提交作业

host:port

yarn.resourcemanager.scheduler.address

ApplicationMasters 通过ResourceManager主机访问host:port跟踪调度程序获资源

host:port

yarn.resourcemanager.resource-tracker.address

NodeManagers通过ResourceManager主机访问host:port

host:port

yarn.resourcemanager.admin.address

管理命令通过ResourceManager主机访问host:port

host:port

yarn.resourcemanager.webapp.address

ResourceManager web页面host:port.

host:port

yarn.resourcemanager.scheduler.class

ResourceManager 调度类（Scheduler class）

CapacityScheduler（推荐），FairScheduler（也推荐），orFifoScheduler

yarn.scheduler.minimum-allocation-mb

每个容器内存最低限额分配到的资源管理器要求

以MB为单位

yarn.scheduler.maximum-allocation-mb

资源管理器分配给每个容器的内存最大限制

以MB为单位

yarn.resourcemanager.nodes.include-path/
yarn.resourcemanager.nodes.exclude-path

NodeManagers的permitted/excluded列表

如有必要，可使用这些文件来控制允许NodeManagers列表

### mapered-site.xml

参数

属性值

解释

mapreduce.framework.name

yarn

执行框架设置为 Hadoop YARN.

mapreduce.map.memory.mb

1536

对maps更大的资源限制的.

mapreduce.map.java.opts

-Xmx2014M

maps中对jvm child设置更大的堆大小

mapreduce.reduce.memory.mb

3072

设置 reduces对于较大的资源限制

mapreduce.reduce.java.opts

-Xmx2560M

reduces对 jvm child设置更大的堆大小

mapreduce.task.io.sort.mb

512

更高的内存限制，而对数据进行排序的效率

mapreduce.task.io.sort.factor

100

在文件排序中更多的流合并为一次

mapreduce.reduce.shuffle.parallelcopies

50

通过reduces从很多的map中读取较多的平行 副本


### 参数汇总

linux参数
以下参数最好优化一下：
文件描述符ulimit -n
用户最大进程 nproc （hbase需要 hbse book）
关闭swap分区
设置合理的预读取缓冲区
Linux的内核的IO调度器

JVM参数
JVM方面的优化项Hadoop Performance Tuning Guide

Hadoop参数大全
适用版本：4.3.0
主要配置文件：
core
hdfs
yarn
mapred
重要性表示如下：
重要
一般
不重要

core-default.xml
hadoop.common.configuration.version
配置文件的版本。

hadoop.tmp.dir=/tmp/hadoop-${user.name}
Hadoop的临时目录，其它目录会基于此路径。本地目录。
只可以设置一个值；建议设置到一个足够空间的地方，而不是默认的/tmp下
服务端参数，修改需重启

hadoop.security.authorization=false
是否开启安全服务验证。
建议不开启。认证操作比较复杂，在公司内部网络下，重要性没那么高

io.file.buffer.size=4096
在读写文件时使用的缓存大小。这个大小应该是内存Page的倍数。
建议1M

io.compression.codecs=null
压缩和解压缩编码类列表，用逗号分隔。这些类是使用Java ServiceLoader加载。

fs.defaultFS=file:///
默认文件系统的名称。URI形式。uri’s的scheme需要由(fs.SCHEME.impl)指定文件系统实现类。 uri’s的authority部分用来指定host, port等。默认是本地文件系统。

HA方式，这里设置服务名，例如：hdfs://mycluster1
HDFS的客户端访问HDFS需要此参数。

fs.trash.interval=0
以分钟为单位的垃圾回收时间，垃圾站中数据超过此时间，会被删除。如果是0，垃圾回收机制关闭。可以配置在服务器端和客户端。如果在服务器端配置trash无效，会检查客户端配置。如果服务器端配置有效，客户端配置会忽略。
建议开启，建议10080（7天）
垃圾回收站，如有同名文件被删除，会给文件顺序编号，例如：a.txt,a.txt(1)

fs.trash.checkpoint.interval=0
以分钟为单位的垃圾回收检查间隔。应该小于或等于fs.trash.interval。如果是0，值等同于fs.trash.interval。每次检查器运行，会创建新的检查点。
建议设置为60（1小时）

dfs.ha.fencing.methods=null
HDFS的HA功能的防脑裂方法。可以是内建的方法(例如shell和sshfence)或者用户定义的方法。建议使用sshfence(hadoop:9922)，括号内的是用户名和端口，注意，这需要NN的2台机器之间能够免密码登陆
fences是防止脑裂的方法，保证NN中仅一个是Active的，如果2者都是Active的，新的会把旧的强制Kill。

dfs.ha.fencing.ssh.private-key-files=null
使用sshfence时，SSH的私钥文件。 使用了sshfence，这个必须指定

ha.zookeeper.quorum=null
Ha功能，需要一组zk地址，用逗号分隔。被ZKFailoverController使用于自动失效备援failover。

ha.zookeeper.session-timeout.ms=5000
ZK连接超时。ZKFC连接ZK时用。设置一个小值可以更快的探测到服务器崩溃（crash),但也会更频繁的触发失效备援，在传输错误或者网络不畅时。建议10s-30s

hadoop.http.staticuser.user=dr.who
在网页界面访问数据使用的用户名。默认值是一个不真实存在的用户，此用户权限很小，不能访问不同用户的数据。这保证了数据安全。也可以设置为hdfs和hadoop等具有较高权限的用户，但会导致能够登陆网页界面的人能看到其它用户数据。实际设置请综合考虑。如无特殊需求。使用默认值就好

fs.permissions.umask-mode=22
在创建文件和目录时使用此umask值（用户掩码）。类linux上的文件权限掩码。可以使用8进制数字也可以使用符号，例如：”022” (8进制，等同于以符号表示的u=rwx,g=r-x,o=r-x)，或者”u=rwx,g=rwx,o=”(符号法，等同于8进制的007)。注意，8进制的掩码，和实际权限设置值正好相反，建议使用符号表示法，描述更清晰

io.native.lib.available=true
是否启动Hadoop的本地库，默认启用。本地库可以加快基本操作，例如IO，压缩等。

hadoop.http.filter.initializers=org.apache.hadoop.http.lib.StaticUserWebFilter
Hadoop的Http服务中，用逗号分隔的一组过滤器类名，每个类必须扩展自org.apache.hadoop.http.FilterInitializer。 这些组件被初始化，应用于全部用户的JSP和Servlet页面。 列表中定义的顺序就是过滤器被调用的顺序。

hadoop.security.authentication
安全验证规则，可以是simple和kerberos。simple意味着不验证。

hadoop.security.group.mapping=org.apache.hadoop.security.JniBasedUnixGroupsMappingWithFallback
user到group的映射类。ACL用它以给定user获取group。默认实现是 org.apache.hadoop.security.JniBasedUnixGroupsMappingWithFallback, 如果JNI有效，它将发挥作用，使用Hadoop的API去获取user的groups列表。如果JNI无效，会使用另一个基于shell的实现, ShellBasedUnixGroupsMapping。这个实现是基于Linux、Unix的shell的环境。

hadoop.security.groups.cache.secs=300
user到gourp映射缓存的有效时间。如果超时，会再次调用去获取新的映射关系然后缓存起来。

hadoop.security.service.user.name.key=null
如果相同的RPC协议被多个Server实现，这个配置是用来指定在客户端进行RPC调用时，使用哪个principal name去联系服务器。不建议使用

hadoop.security.uid.cache.secs=14400
安全选项。不建议使用

hadoop.rpc.protection=authentication
rpc连接保护。可取的值有authentication（认证）, integrity（完整） and privacy（隐私）。不建议使用

hadoop.work.around.non.threadsafe.getpwuid=false
一些系统已知在调用getpwuid_r和getpwgid_r有问题，这些调用是非线程安全的。这个问题的主要表现特征是JVM崩溃。如果你的系统有这些问题，开启这个选项。默认是关闭的。

hadoop.kerberos.kinit.command=kinit
用来定期的向Hadoop提供新的Kerberos证书。所提供命令需要能够在运行Hadoop客户端的用户路径中查找到，否则，请指定绝对路径。不建议使用

hadoop.security.auth_to_local=null
映射kerberos principals（代理人）到本地用户名

io.bytes.per.checksum=512
每次进行校验和检查的字节数。一定不能大于io.file.buffer.size.

io.skip.checksum.errors=FALSE
是否跳过校验和错误，默认是否，校验和异常时会抛出错误。

io.serializations=org.apache.hadoop.io.serializer.WritableSerialization,org.apache.hadoop.io.serializer.avro.AvroSpecificSerialization,org.apache.hadoop.io.serializer.avro.AvroReflectSerialization
序列化类列表，可以被用来获取序列化器和反序列化器（serializers and deserializers）。

io.seqfile.local.dir=${hadoop.tmp.dir}/io/local
本地文件目录。sequence file在merge过程中存储内部数据的地方。可以是逗号分隔的一组目录。最好在不同磁盘以分散IO。实际不存在的目录会被忽略。

io.map.index.skip=0
跳过的索引实体数量在entry之间。默认是0。设置大于0的值可以用更少的内存打开大MapFiles。注意：MpaFile是一组Sequence文件，是排序后的，带内部索引的文件

io.map.index.interval=128
MapFile包含两个文件，数据文件和索引文件。每io.map.index.interval个记录写入数据文件，一条记录(行key，数据文件位置)写入索引文件。

fs.default.name=file:///
过时。使用(fs.defaultFS)代替

fs.AbstractFileSystem.file.impl=org.apache.hadoop.fs.local.LocalFs
文件系统实现类：file

fs.AbstractFileSystem.hdfs.impl=org.apache.hadoop.fs.Hdfs
文件系统实现类：hdfs

fs.AbstractFileSystem.viewfs.impl=org.apache.hadoop.fs.viewfs.ViewFs
文件系统实现类：viewfs (例如客户端挂载表)。
在实现federation特性时，客户端可以部署此系统，方便同时访问多个nameservice

fs.ftp.host=0.0.0.0
非Hdfs文件系统设置。暂不关注

fs.ftp.host.port=21
非Hdfs文件系统设置。暂不关注

fs.df.interval=60000
磁盘使用统计刷新间隔，以毫秒为单位

fs.s3.block.size=67108864
非Hdfs文件系统设置。暂不关注

fs.s3.buffer.dir=${hadoop.tmp.dir}/s3
非Hdfs文件系统设置。暂不关注

fs.s3.maxRetries=4
非Hdfs文件系统设置。暂不关注

fs.s3.sleepTimeSeconds=10
非Hdfs文件系统设置。暂不关注

fs.automatic.close=true
默认的，文件系统实例在程序退出时自动关闭，通过JVM shutdown hook方式。可以把此属性设置为false取消这种操作。这是一个高级选项，需要使用者特别关注关闭顺序。不要关闭

fs.s3n.block.size=67108864
非Hdfs文件系统设置。暂不关注

io.seqfile.compress.blocksize=1000000
SequenceFiles以块压缩方式压缩时，块大小大于此值时才启动压缩。

io.seqfile.lazydecompress=TRUE
懒惰解压，仅在必要时解压，仅对块压缩的SequenceFiles有效。

io.seqfile.sorter.recordlimit=1000000
在SequenceFiles.Sorter spill过程中，保存在内存中的记录数

io.mapfile.bloom.size=1048576
在BloomMapFile使用的布隆过滤器内存大小。

io.mapfile.bloom.error.rate=0.005
BloomMapFile中使用布隆过滤器失败比率. 如果减少这个值，使用的内存会成指数增长。

hadoop.util.hash.type=murmur
默认Hash算法实现. ‘murmur’:MurmurHash, ‘jenkins’:JenkinsHash.

ipc.client.idlethreshold=4000
连接数阀值，超过此值，需要进行空闲连接检查

ipc.client.kill.max=10
定义客户端最大数量，超过会被断开连接

ipc.client.connection.maxidletime=10000
毫秒，最大时间，超过后客户端会断开和服务器的连接。

ipc.client.connect.max.retries=10
客户端连接重试次数。

ipc.client.connect.max.retries.on.timeouts=45
在连接超时后，客户端连接重试次数

ipc.server.listen.queue.size=128
定义服务器端接收客户端连接的监听队列长度

ipc.server.tcpnodelay=false
在服务器端开启/关闭Nagle’s算法，此算法可以延迟小数据包发送，从而达到网络流量更有效利用。但是这对小数据包是不利的。默认关闭。建议false，即开启Nagle算法

ipc.client.tcpnodelay=false
参考ipc.server.tcpnodelay，客户端参数。或许可以考虑关闭Nagle算法，增加客户端响应速度

hadoop.rpc.socket.factory.class.default=org.apache.hadoop.net.StandardSocketFactory
高级选项，暂不考虑

hadoop.rpc.socket.factory.class.ClientProtocol=null
高级选项，暂不考虑

hadoop.socks.server=null
高级选项，暂不考虑

net.topology.node.switch.mapping.impl=org.apache.hadoop.net.ScriptBasedMapping
机架感知实现类。

net.topology.script.file.name=null
配合ScriptBasedMapping使用。脚本文件。此脚本文件，输入是ip地址，输出是机架路径。

net.topology.script.number.args=100
机架感知脚本文件的参数最大数量。脚本每次运行被传递的参数，每个参数是一个ip地址

net.topology.table.file.name=null
在net.topology.script.file.name被设置为 org.apache.hadoop.net.TableMapping时，可以使用此配置。文件格式是一个有两个列的文本文件，使用空白字符分隔。第一列是DNS或IP地址，第二列是机架路径。如无指定，使用默认机架（/default-rack）

file.stream-buffer-size=4096
非hdfs文件系统，暂不关注

s3.stream-buffer-size=4096
非hdfs文件系统，暂不关注

kfs.stream-buffer-size=4096
非hdfs文件系统，暂不关注

ftp.stream-buffer-size=4096
非hdfs文件系统，暂不关注

tfile.io.chunk.size=1048576
非hdfs文件系统，暂不关注

hadoop.http.authentication.type=simple
Oozie Http终端安全验证。可选值：simple | kerberos |#AUTHENTICATION_HANDLER_CLASSNAME#
建议simple，关闭验证

hadoop.http.authentication.token.validity=36000
安全选项。暂不关注

hadoop.http.authentication.signature.secret.file=${user.home}/hadoop-http-auth-signature-secret
安全选项。暂不关注

hadoop.http.authentication.cookie.domain=null
安全选项。暂不关注

hadoop.http.authentication.simple.anonymous.allowed=TRUE
安全选项。暂不关注

hadoop.http.authentication.kerberos.principal=HTTP/_HOST@LOCALHOST
安全选项。暂不关注

hadoop.http.authentication.kerberos.keytab=${user.home}/hadoop.keytab
安全选项。暂不关注

dfs.ha.fencing.ssh.connect-timeout=30000
SSH连接超时，毫秒，仅适用于内建的sshfence fencer。

ha.zookeeper.parent-znode=/hadoop-ha
ZK失效备援功能，需要在ZK上创建节点，这里是根节点的名称。ZKFC会在这下面工作。注意，NameService ID会 被写到此节点下，所以即便是开启federation功能，也仅需要指定一个值。

ha.zookeeper.acl=world:anyone:rwcda
ZKFC创建的ZK节点的访问控制权限设置。可以多个，逗号分隔。此设置和ZK的CLI使用相同的格式。

ha.zookeeper.auth=null
ZK操作时的权限验证。

hadoop.ssl.keystores.factory.class=org.apache.hadoop.security.ssl.FileBasedKeyStoresFactory
安全选项。暂不关注

hadoop.ssl.require.client.cert=FALSE
安全选项。暂不关注

hadoop.ssl.hostname.verifier=DEFAULT
安全选项。暂不关注

hadoop.ssl.server.conf=ssl-server.xml
安全选项。暂不关注

hadoop.ssl.client.conf=ssl-client.xml
安全选项。暂不关注

hadoop.ssl.enabled=FALSE
安全选项。暂不关注

hadoop.jetty.logs.serve.aliases=TRUE
是否允许在Jetty中使用别名服务。

ha.health-monitor.connect-retry-interval.ms=1000
HA功能的健康监控连接重试间隔

ha.health-monitor.check-interval.ms=1000
HA功能的健康监控连接间隔

ha.health-monitor.sleep-after-disconnect.ms=1000
HA功能的健康监控，在因网络问题失去连接后休眠多久。用于避免立即重试，此时网络问题仍在，没有意义

ha.health-monitor.rpc-timeout.ms=45000
HA功能健康监控的超时时间，毫秒

ha.failover-controller.new-active.rpc-timeout.ms=60000
FC等待新的NN变成active状态的超时时间。

ha.failover-controller.graceful-fence.rpc-timeout.ms=5000
FC等待旧的active变成standby的超时时间。

ha.failover-controller.graceful-fence.connection.retries=1
FC在做完美隔离是的连接重试次数（graceful fencing）

ha.failover-controller.cli-check.rpc-timeout.ms=20000
手动运行的FC功能（从CLI）等待健康检查、服务状态的超时时间。

hdfs-default.xml
hadoop.hdfs.configuration.version=1
配置文件的版本

dfs.datanode.address=0.0.0.0:50010
DN服务地址和端口，用于数据传输。0表示任意空闲端口。
xferPort dfs.datanode.address 50010 数据流地址 数据传输
infoPort dfs.datanode.http.address 50075
ipcPort dfs.datanode.ipc.address 50020 命令

dfs.datanode.http.address=0.0.0.0:50075
DN的HTTP服务地址和端口。0表示任意空闲端口。

dfs.datanode.ipc.address=0.0.0.0:50020
DN的IPC地址和端口。0表示任意空闲端口。

dfs.namenode.rpc-address=0.0.0.0:50090
NN的RPC地址和端口

dfs.namenode.http-address=0.0.0.0:50070
NN的HTTP地址和端口。0表示任意空闲端口。

dfs.datanode.du.reserved=0
每个磁盘（volume）的保留空间，字节。要注意留足够的空间给非HDFS文件使用。建议保留磁盘容量的5%或者50G以上

dfs.namenode.name.dir.restore=FALSE
设置为true，允许NN尝试恢复之前失败的dfs.namenode.name.dir目录。在创建checkpoint是做此尝试。如果设置多个磁盘，建议允许

dfs.namenode.edits.dir=${dfs.namenode.name.dir}
本地文件，NN存放edits文件的目录。可以是逗号分隔的目录列表。edits文件会存储在每个目录，冗余安全。

dfs.namenode.shared.edits.dir=null
在多个NN中共享存储目录，用于存放edits文件。这个目录，由active写，由standby读，以保持命名空间数据一致。此目录不需要是dfs.namenode.edits.dir中列出的。在非HA集群中，它不会使用。建议使用qj方式，可以不关注这个选项

dfs.namenode.edits.journal-plugin.qjournal=org.apache.hadoop.hdfs.qjournal.client.QuorumJournalManager
qj方式共享edits。建议使用此方式

dfs.permissions.enabled=true
是否在HDFS中开启权限检查。

dfs.permissions.superusergroup=supergroup
超级用户组。仅能设置一个。

dfs.datanode.data.dir=file://${hadoop.tmp.dir}/dfs/data
本地磁盘目录，HDFS数据应该存储Block的地方。可以是逗号分隔的目录列表（典型的，每个目录在不同的磁盘）。这些目录被轮流使用，一个块存储在这个目录，下一个块存储在下一个目录，依次循环。每个块在同一个机器上仅存储一份。不存在的目录被忽略。必须创建文件夹，否则被视为不存在。

dfs.replication=3
数据块副本数。此值可以在创建文件是设定，客户端可以只有设定，也可以在命令行修改。不同文件可以有不同的副本数。默认值用于未指定时。

dfs.replication.max=512
最大块副本数，不要大于节点总数。

dfs.namenode.replication.min=1
最小块副本数。在上传文件时，达到最小副本数，就认为上传是成功的

dfs.blocksize=67108864
块大小，字节。可以使用后缀: k(kilo), m(mega), g(giga), t(tera), p(peta), e(exa)指定大小 (就像128k, 512m, 1g, 等待)。

dfs.client.block.write.retries=3
客户端写数据到DN时，最大重试次数。超过重试次数就会报出错误。

dfs.client.block.write.replace-datanode-on-failure.enable=true
在进行pipeline写数据（上传数据的方式）时，如果DN或者磁盘故障，客户端将尝试移除失败的DN，然后写到剩下的磁盘。一个结果是，pipeline中的DN减少了。这个特性是添加新的DN到pipeline。这是一个站点范围的选项。当集群规模非常小时，例如3个或者更小，集群管理者可能想要禁止掉此特性。

dfs.client.block.write.replace-datanode-on-failure.policy=DEFAULT
此属性仅在dfs.client.block.write.replace-datanode-on-failure.enable设置为true时有效。
ALWAYS: 总是添加新的DN
NEVER: 从不添加新的DN
DEFAULT: 设r是副本数，n是要写的DN数。在r>=3并且floor(r/2)>=n或者r>n(前提是文件是hflushed/appended)时添加新的DN。

dfs.heartbeat.interval=3
DN的心跳间隔，秒

dfs.namenode.handler.count=10
NN的服务线程数。用于处理RPC请求。

dfs.namenode.safemode.threshold-pct=0.999f
数据进入安全模式阀值，百分比，float形式，数据块达到最小副本数（dfs.namenode.replication.min）的百分比。值小于等于0意味着在退出安全模式前不等待数据修复。大于1的值将导致无法离开安全模式。

dfs.namenode.safemode.extension=30000
安全模式扩展存在时间，在需要的阀值达到后，毫秒。可以设置为0，或者比较短的一个时间，例如3秒

dfs.datanode.balance.bandwidthPerSec=1048576
在做数据平衡时，每个DN最大带宽占用，每秒字节。默认值是1M。建议可以到10M

dfs.hosts=null
文件名，包含了一个host列表，允许列表内机器连到NN。必须指定完整路径。如果值为空，全部hosts都允许连入。

dfs.hosts.exclude=null
文件名，包含了一个hosts列表，不允许列表内机器连到NN。必须指定完整路径。如果值为空。没有host被禁止。如果上述2个都设置并且有重合，dfs.hosts中优先级高。

dfs.stream-buffer-size=4096
文件流缓存大小。需要是硬件page大小的整数倍。在读写操作时，数据缓存大小。注意和core-default.xml中指定文件类型的缓存是不同的，这个是dfs共用的

dfs.namenode.num.extra.edits.retained=1000000
除最小的必须的editlog之外，额外保留的editlog文件数量。这是有用的，可以用于审核目的，或者HA设置一个远程Standby节点并且有时可能离线时，都需要保留一个较长的backlog。
典型的，每个edit大约几百字节，默认的1百万editlog大约有百兆到1G。注意：早先的extra edits文件可能操作这里设置的值，因为还有其它选项，例如dfs.namenode.max.extra.edits.segments.retained
建议值：2200，约3天的

dfs.datanode.handler.count=10
DN的服务线程数。这些线程仅用于接收请求，处理业务命令

dfs.datanode.failed.volumes.tolerated=0
可以接受的卷的失败数量。默认值0表示，任一个卷失败都会导致DN关闭。
建议设置此值，避免个别磁盘问题。如果此值超过真实磁盘数，将会报错，启动失败

dfs.namenode.support.allow.format=true
NN是否允许被格式化？在生产系统，把它设置为false，阻止任何格式化操作在一个运行的DFS上。
建议初次格式化后，修改配置禁止

dfs.client.failover.max.attempts=15
专家设置。客户端失败重试次数。

dfs.client.failover.connection.retries=0
专家设置。IPC客户端失败重试次数。在网络不稳定时建议加大此值

dfs.client.failover.connection.retries.on.timeouts=0
专家设置。IPC客户端失败重试次数，此失败仅指超时失败。在网络不稳定时建议加大此值

dfs.nameservices=null
nameservices列表。逗号分隔。
我们常用的仅配置一个，启动federation功能需要配置多个

dfs.nameservice.id=null
nameservice id，如果没有配置或者配置多个，由匹配到的本地节点地址配置的IP地址决定。我们进配置一个NS的情况下，建议这里不配置

dfs.ha.namenodes.EXAMPLENAMESERVICE=null
包含一个NN列表。EXAMPLENAMESERVICE是指具体的nameservice名称，通常就是dfs.nameservices中配置的。值是预备配置的NN的ID。
ID是自己取的，不重复就可以，例如nn1,nn2

dfs.ha.namenode.id=null
NN的ID，如果没有配置，由系统决定。通过匹配本地节点地址和配置的地址。
这里设置的是本机的NN的ID（此配置仅对NN生效），由于要配置2个NN，建议没有特殊需要，这里不进行配置

dfs.ha.automatic-failover.enabled=FALSE
是否开启自动故障转移。建议开启，true

dfs.namenode.avoid.write.stale.datanode=FALSE
决定是否避开在脏DN上写数据。写操作将会避开脏DN，除非超过一个配置的比率 (dfs.namenode.write.stale.datanode.ratio)。
尝试开启

dfs.journalnode.rpc-address=0.0.0.0:8485
JournalNode RPC服务地址和端口

dfs.journalnode.http-address=0.0.0.0:8480
JournalNode的HTTP地址和端口。端口设置为0表示随机选择。

dfs.namenode.audit.loggers=default
审查日志的实现类列表，能够接收audit事件。它们需要实现 org.apache.hadoop.hdfs.server.namenode.AuditLogger接口。默认值”default”可以用于引用默认的audit logger， 它使用配置的日志系统。安装客户自己的audit loggers可能影响NN的稳定性和性能。
建议default，开启

dfs.client.socket-timeout=60*1000
dfs.datanode.socket.write.timeout=8*60*1000
dfs.datanode.socket.reuse.keepalive=1000
dfs.namenode.logging.level=info
DFS的NN的日志等级。值可以是：info，dir(跟踪命名空间变动)，”block” (跟踪块的创建删除，replication变动)，或者”all”.

dfs.namenode.secondary.http-address=0.0.0.0:50090
SNN的http服务地址。如果是0，服务将随机选择一个空闲端口。使用了HA后，就不再使用SNN了

dfs.https.enable=FALSE
允许HDFS支持HTTPS(SSL)。建议不支持

dfs.client.https.need-auth=FALSE
安全选项，暂不关注

dfs.https.server.keystore.resource=ssl-server.xml
安全选项，暂不关注

dfs.client.https.keystore.resource=ssl-client.xml
安全选项，暂不关注

dfs.datanode.https.address=0.0.0.0:50475
安全选项，暂不关注

dfs.namenode.https-address=0.0.0.0:50470
安全选项，暂不关注

dfs.datanode.dns.interface=default
DN汇报它的IP地址的网卡。我们给DN指定了0.0.0.0之类的地址，这个地址需要被解析成对外地址，这里指定的是网卡名，即那个网卡上绑定的IP是可以对外的IP，一般的，默认值就足够了

dfs.datanode.dns.nameserver=default
DNS的域名或者IP地址。DN用它来确定自己的域名，在对外联系和显示时调用。一般的，默认值就足够了

dfs.namenode.backup.address=0.0.0.0:50100
NN的BK节点地址和端口，0表示随机选用。使用HA，就不需要关注此选项了。建议不使用BK节点

dfs.namenode.backup.http-address=0.0.0.0:50105
使用HA，就不需要关注此选项了。建议不使用BK节点

dfs.namenode.replication.considerLoad=true
设定在选择存放目标时是否考虑负载。需要

dfs.default.chunk.view.size=32768
在浏览器中查看一个文件时，可以看到的字节数。

dfs.namenode.name.dir=file://${hadoop.tmp.dir}/dfs/name
本地磁盘目录，NN存储fsimage文件的地方。可以是按逗号分隔的目录列表，fsimage文件会存储在全部目录，冗余安全。这里多个目录设定，最好在多个磁盘，另外，如果其中一个磁盘故障，不会导致系统故障，会跳过坏磁盘。由于使用了HA，建议仅设置一个。如果特别在意安全，可以设置2个

dfs.namenode.fs-limits.max-component-length=0
路径中每个部分的最大字节长度（目录名，文件名的长度）。0表示不检查长度。长文件名影响性能

dfs.namenode.fs-limits.max-directory-items=0
设置每个目录最多拥有多少个子目录或者文件。0表示无限制。同一目录下子文件和目录多影响性能

dfs.namenode.fs-limits.min-block-size=1048576
最小的Block大小，字节。在NN创建时强制验证。避免用户设定过小的Block Size，导致过多的Block，这非常影响性能。

dfs.namenode.fs-limits.max-blocks-per-file=1048576
每个文件最大的Block数。在NN写时强制检查。用于防止创建超大文件。

dfs.block.access.token.enable=FALSE
访问DN时是否验证访问令牌。建议false，不检查

dfs.block.access.key.update.interval=600
安全选项，暂不关注

dfs.block.access.token.lifetime=600
安全选项，暂不关注

dfs.datanode.data.dir.perm=700
本地数据目录权限设定。8进制或者符号方式都可以。

dfs.blockreport.intervalMsec=21600000
数据块汇报间隔，毫秒，默认是6小时。

dfs.blockreport.initialDelay=0
第一次数据块汇报时延迟，秒。目的是减轻NN压力？

dfs.datanode.directoryscan.interval=21600
DN的数据块扫描间隔，秒。磁盘上数据和内存中数据调整一致。

dfs.datanode.directoryscan.threads=1
线程池要有多少线程用来并发的压缩磁盘的汇报数据。

dfs.namenode.safemode.min.datanodes=0
NN收到回报的DN的数量的最小值，达不到此值，NN不退出安全模式。（在系统启动时发生作用）。<=0的值表示不关心DN数量，在启动时。大于DN实际数量的值会导致无法离开安全模式。建议不设置此值

dfs.namenode.max.objects=0
DFS支持的最大文件、目录、数据块数量。0无限制。

dfs.namenode.decommission.interval=30
NN周期性检查退役是否完成的间隔，秒。

dfs.namenode.decommission.nodes.per.interval=5
NN检查退役是否完成，每dfs.namenode.decommission.interval秒检查的节点数量。

dfs.namenode.replication.interval=3
NN周期性计算DN的副本情况的频率，秒。

dfs.namenode.accesstime.precision=3600000
HDFS文件的访问时间精确到此值，默认是1小时。0表示禁用访问时间。

dfs.datanode.plugins=null
DN上的插件列表，逗号分隔。

dfs.namenode.plugins=null
NN上的插件列表，逗号分隔。

dfs.bytes-per-checksum=512
每次计算校验和的字节数。一定不能大于dfs.stream-buffer-size。

dfs.client-write-packet-size=65536
客户端写数据时的包的大小。包是块中的更小单位数据集合

dfs.client.write.exclude.nodes.cache.expiry.interval.millis=600000
最大周期去让DN保持在例外节点队列中。毫秒。操过此周期，先前被排除的DN将被移除缓存并被尝试再次申请Block。默认为10分钟。

dfs.namenode.checkpoint.dir=file://${hadoop.tmp.dir}/dfs/namesecondary
本地文件系统中，DFS SNN应该在哪里存放临时[用于合并|合并后]（to merge）的Image。如果是逗号分隔的目录列表，Image文件存放多份。冗余备份。建议不使用SNN功能，忽略此配置

dfs.namenode.checkpoint.edits.dir=${dfs.namenode.checkpoint.dir}
建议不使用SNN功能，忽略此配置

dfs.namenode.checkpoint.period=3600
建议不使用SNN功能，忽略此配置

dfs.namenode.checkpoint.txns=1000000
建议不使用SNN功能，忽略此配置

dfs.namenode.checkpoint.check.period=60
建议不使用SNN功能，忽略此配置

dfs.namenode.checkpoint.max-retries=3
建议不使用SNN功能，忽略此配置

dfs.namenode.num.checkpoints.retained=2
建议不使用SNN功能，忽略此配置

dfs.namenode.num.extra.edits.retained=1000000
数量限制，额外的edits事务数。

dfs.namenode.max.extra.edits.segments.retained=10000
extra edit日志文件segments的最大数量。除了用于NN重启时的最小edits文件之外。一个segments包含多个日志文件

dfs.namenode.delegation.key.update-interval=86400000
NN中更新主代理令牌的时间间隔，毫秒。安全选项，不关注

dfs.namenode.delegation.token.max-lifetime=604800000
NN中更新主代理令牌的时间间隔，毫秒。安全选项，不关注

dfs.namenode.delegation.token.renew-interval=86400000
NN中更新主代理令牌的时间间隔，毫秒。安全选项，不关注

dfs.image.compress=FALSE
Image文件要压缩吗？

dfs.image.compression.codec=org.apache.hadoop.io.compress.DefaultCodec
Image文件压缩编码。必须是在io.compression.codecs中定义的编码。

dfs.image.transfer.timeout=600000
Image文件传输时超时。HA方式使用不到，可不关注

dfs.image.transfer.bandwidthPerSec=0
Image文件传输时可以使用的最大带宽，秒字节。0表示没有限制。HA方式使用不到，可不关注

dfs.datanode.max.transfer.threads=4096
= 旧参数 dfs.datanode.max.xcievers
DN上传送数据出入的最大线程数。

dfs.datanode.readahead.bytes=4193404
预读磁盘数据。如果Hadoop本地库生效，DN可以调用posix_fadvise系统获取页面数据到操作系统的缓存中。这个配置指定读取当前读取位置之前的字节数。设置为0，取消此功能。无本地库，此功能也无效。？

dfs.datanode.drop.cache.behind.reads=FALSE
在有些场景下，特别是对一些大的，并且不可能重用的数据，缓存在操作系统的缓存区是无用的。此时，DN可以配置自动清理缓存区数据，在已经发生向客户端之后。此功能自动失效，在读取小数据片时。(例如HBase的随机读写场景）。通过释放缓存，这在某些场景下可以提高性能。Hadoop本地库无效，此功能无效。看起来是一个可以尝试的特性

dfs.datanode.drop.cache.behind.writes=FALSE
同dfs.datanode.drop.cache.behind.reads相似。

dfs.datanode.sync.behind.writes=FALSE
如果是true，在写之后，DN将指示操作系统把队列中数据全部立即写磁盘。和常用的OS策略不同，它们可能在触发写磁盘之前等待30秒。Hadoop本地库无效，此功能无效。

dfs.client.failover.sleep.base.millis=500
专家设置。失败重试间的等待时间，毫秒。这里的值是个基本值，实际值会根据失败/成功次数递增/递减50%。第一次失败会立即重试。第二次将延迟至少dfs.client.failover.sleep.base.millis毫秒。依次类推。

dfs.client.failover.sleep.max.millis=15000
专家设置。失败重试见的等待时间最大值，毫秒。

dfs.ha.log-roll.period=120
StandbyNode要求Active滚动EditLog，由于StandBy只能从已经完成的Log Segments中读，所以Standby上的数据新鲜程度依赖于以如何的频率滚动日志。秒。另外，故障转移也会触发一次日志滚动，所以StandbyNode在Active之前，数据也会更新成最新的。秒，默认是2分钟。

dfs.ha.tail-edits.period=60
StandbyNode以此频率检测共享目录中最新的日志，秒。

dfs.ha.zkfc.port=8019
zkfc的rpc端口

dfs.support.append=TRUE
是否允许append。

dfs.client.use.datanode.hostname=FALSE
是否客户端应该使用DN的HostName，在连接DN时，默认是使用IP。

dfs.datanode.use.datanode.hostname=FALSE
是否DN应该使用HostName连接其它DN，在数据传输时。默认是是IP。

dfs.client.local.interfaces=null
逗号分隔的网卡列表，用于在客户端和DN之间传输数据时。当创建连接时，客户端随机选择一个并绑定它的socket到这个网卡的IP上。名字可以以网卡名(例如 “eth0”), 子网卡名 (eg “eth0:0”), 或者IP地址(which may be specified using CIDR notation to match a range of IPs)。

dfs.namenode.kerberos.internal.spnego.principal=${dfs.web.authentication.kerberos.principal}
安全选项，暂不关注

dfs.secondary.namenode.kerberos.internal.spnego.principal=${dfs.web.authentication.kerberos.principal}
安全选项，暂不关注

dfs.namenode.avoid.read.stale.datanode=FALSE
决定是否避开从脏DN上读数据。脏DN指在一个指定的时间间隔内没有收到心跳信息。脏DN将被移到可以读取节点列表的尾端。尝试开启

dfs.namenode.stale.datanode.interval=30000
标记一个DN是脏的时间间隔。例如，如果NN在此设定的时间内没有接收到来自某一个节点的心跳信息，此DN将被标记为脏的。此间隔不能太小，否则容易导致被频繁的标记为脏DN。
我们建议是1分钟

dfs.namenode.write.stale.datanode.ratio=0.5f
当全部DN被标记为脏DN的比率高于此阀值，停止不写数据到脏DN的策略，以免造成热点问题（有效的，可写的DN太少，压力太大）。

dfs.namenode.invalidate.work.pct.per.iteration=0.32f
高级属性。改变需小心。

dfs.namenode.replication.work.multiplier.per.iteration=2
高级属性。改变需小心。

dfs.webhdfs.enabled=FALSE
在NN和DN上开启WebHDFS (REST API)功能。
可以开启尝试

hadoop.fuse.connection.timeout=300
秒，在fuse_dfs中缓存libhdfs连接对象的超时时间。 小值使用内存小。大值可以加快访问，通过避开创建新的连接对象。

hadoop.fuse.timer.period=5
秒

dfs.metrics.percentiles.intervals=null
Comma-delimited set of integers denoting the desired rollover intervals (in seconds) for percentile latency metrics on the Namenode and Datanode. By default, percentile latency metrics are disabled.

dfs.encrypt.data.transfer=FALSE
是否加密传输数据？仅需要配置在NN和DN。客户端可以自行判断。

dfs.encrypt.data.transfer.algorithm=null
可以设置为”3des”或”rc4”。否则使用默认的，通常是usually 3DES。3DES更安全，RC4更快。

dfs.datanode.hdfs-blocks-metadata.enabled=TRUE
布尔值，设定后台DN端是否支持DistributedFileSystem#getFileVBlockStorageLocations API。

dfs.client.file-block-storage-locations.num-threads=10
在调用DistributedFileSystem#getFileBlockStorageLocations()的并发RPC的线程数

dfs.client.file-block-storage-locations.timeout=60
Timeout (in seconds) for the parallel RPCs made in DistributedFileSystem#getFileBlockStorageLocations().

dfs.domain.socket.path=/var/run/hadoop-hdfs/dn._PORT
可选选项。socket文件路径，unix下。用来在DN和本地的HDFS客户端加快网络连接。如果字符串”_PORT”出现在路径中，它将被DN的TCP端口替换。

yarn-default.xml
yarn.app.mapreduce.am.env=null
用户为MR AM添加环境变量。例如：
A=foo 设置环境变量A为foo
B=$B:c 继承并设置TT内的B变量

yarn.app.mapreduce.am.command-opts=-Xmx1024m
MR AM的Java opts。如下符号会被替换：
@taskid@ 被替换成当前的TaskID。其它出现的’@’不会改变。例如，为了让gc日志能够按task打印存储在/tmp目录，可以设置’value’为：-Xmx1024m -verbose:gc -Xloggc:/tmp/@taskid@.gc
如果hadoop本地库可以使用，使用-Djava.library.path参数可能造成程序的此功能无效。这个值应该被替换，设置在MR的JVM环境中LD_LIBRARY_PATH变量中，使用 mapreduce.map.env和mapreduce.reduce.env配置项。

yarn.app.mapreduce.am.resource.mb=1536
AM申请的内存

yarn.resourcemanager.address=0.0.0.0:8032
RM地址:端口

yarn.resourcemanager.scheduler.address=0.0.0.0:8030
调度器地址：端口

yarn.admin.acl=*
ACL中谁可以管理YARN集群

yarn.resourcemanager.admin.address=0.0.0.0:8033
RM管理接口地址：端口

yarn.resourcemanager.am.max-retries=1
AM重试最大次数。服务端参数。重启生效。
建议4

yarn.resourcemanager.nodes.include-path=null
存储有效节点列表的文件

yarn.resourcemanager.nodes.exclude-path=null
存储拒绝节点列表的文件。如和包含文件冲突，包含文件优先级高

yarn.resourcemanager.scheduler.class=org.apache.hadoop.yarn.server.resourcemanager.scheduler.fifo.FifoScheduler
调度器实现类。
建议使用公平调度器

yarn.scheduler.minimum-allocation-mb=1024
每个container想RM申请内存的最小大小。兆字节。内存请求小于此值，实际申请到的是此值大小。默认值偏大

yarn.scheduler.maximum-allocation-mb=8192
每个container向RM申请内存的最大大小，兆字节。申请值大于此值，将最多得到此值内存。

yarn.resourcemanager.recovery.enabled=FALSE
是否启动RM的状态恢复功能。如果true，必须指定yarn.resourcemanager.store.class。尝试启用

yarn.resourcemanager.store.class=null
用于持久存储的类。尝试开启

yarn.resourcemanager.max-completed-applications=10000
RM中保存的最大完成的app数量。内存中存储。

yarn.nodemanager.address=0.0.0.0:0
NM中的container管理器的地址：端口

yarn.nodemanager.env-whitelist=JAVA_HOME,HADOOP_COMMON_HOME,HADOOP_HDFS_HOME,HADOOP_CONF_DIR,YARN_HOME
container应该覆盖而不是使用NM的环境变量名单。允许container自己配置的环境变量

yarn.nodemanager.delete.debug-delay-sec=0
秒，一个app完成后，NM删除服务将删除app的本地文件目录和日志目录。为了诊断问题，把这个选项设置成足够大的值（例如，设置为10分钟），可以继续访问这些目录。设置此选项，需要重启NM。Yarn应用的工作目录根路径是yarn.nodemanager.local-dirs，Yarn应用日志目录的根路径是yarn.nodemanager.log-dirs。
调试问题时可用

yarn.nodemanager.local-dirs=${hadoop.tmp.dir}/nm-local-dir
本地文件存储目录，列表。一个应用的本地文件目录定位方式：yarn.nodemanager.local−dirs/usercache/yarn.nodemanager.local−dirs/usercache/{user}/appcache/application_${appid}。每个container的工作目录，是此目录的子目录，目录名是container_${contid}。
非常重要，建议配置多个磁盘，平衡IO。

yarn.nodemanager.log-dirs=${yarn.log.dir}/userlogs
存储container日志的地方。一个应用的本地日志目录定位是：${yarn.nodemanager.log-dirs}/application_${appid}。每个container的日志目录在此目录下，名字是container_{$contid}。每个container目录中包含stderr, stdin, and syslog等container产生的文件
非常重要，建议配置多个磁盘

yarn.log-aggregation-enable=FALSE
是否允许日志汇聚功能。建议开启

yarn.log-aggregation.retain-seconds=-1
保存汇聚日志时间，秒，超过会删除，-1表示不删除。 注意，设置的过小，将导致NN垃圾碎片。建议3-7天 = 7 * 86400 = 604800

yarn.nodemanager.log.retain-seconds=10800
保留用户日志的时间，秒。在日志汇聚功能关闭时生效。
建议7天

yarn.nodemanager.remote-app-log-dir=/tmp/logs
汇聚日志的地方，目录路径，HDFS系统。
对于开了权限检查的系统，注意权限问题。HDFS上。

yarn.nodemanager.remote-app-log-dir-suffix=logs
汇聚日志目录路径后缀。汇聚目录创建在{yarn.nodemanager.remote-app-log-dir}/${user}/{thisParam}

yarn.nodemanager.resource.memory-mb=8192
NM上可以用于container申请的物理内存大小，MB。

yarn.nodemanager.vmem-pmem-ratio=2.1
在设置container的内存限制时，虚拟内存到物理内存的比率。Container申请的内存如果超过此物理内存，可以以此比率获取虚拟内存用于满足需求。虚拟地址的是物理地址的倍数上限。建议设置的大点，例如：4.1，8.1，此虚拟内存并非内存，而是占用的虚拟地址。

yarn.nodemanager.webapp.address=0.0.0.0:8042
NM的网页界面地址和端口。

yarn.nodemanager.log-aggregation.compression-type=none
汇聚日志的压缩类型。汇聚日志是TFile格式文件。Hadoop-3315。可以使用的值有none,lzo,gz等。
可以尝试

yarn.nodemanager.aux-services=null
请配置为：mapreduce.shuffle，在Yarn上开启MR的必须项

yarn.nodemanager.aux-services.mapreduce.shuffle.class=org.apache.hadoop.mapred.ShuffleHandler
对应参考yarn.nodemanager.aux-services

mapreduce.job.jar=null
Job客户端参数。提交的job的jar文件。

mapreduce.job.hdfs-servers=${fs.defaultFS}
Job客户端参数。

yarn.application.classpath=$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/share/hadoop/common/,$HADOOP_COMMON_HOME/share/hadoop/common/lib/,$HADOOP_HDFS_HOME/share/hadoop/hdfs/,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/,$YARN_HOME/share/hadoop/yarn/,$YARN_HOME/share/hadoop/yarn/lib/
YARN应用的CLASSPATH，逗号分隔列表。

yarn.app.mapreduce.am.job.task.listener.thread-count=30
MR AM处理RPC调用的线程数。

yarn.app.mapreduce.am.job.client.port-range=null
MR AM能够绑定使用的端口范围。例如：50000-50050,50100-50200。 如果你先要全部的有用端口，可以留空（默认值null）。

yarn.app.mapreduce.am.job.committer.cancel-timeout=60000
毫秒，如果job被kill了，等待output committer取消操作的时间。

yarn.app.mapreduce.am.scheduler.heartbeat.interval-ms=1000
MR AM发送心跳到RM的时间间隔，毫秒

yarn.app.mapreduce.client-am.ipc.max-retries=3
在重新连接RM获取Application状态前，客户端重试连接AM的次数。

yarn.app.mapreduce.client.max-retries=3
客户端重连RM/HS/AM的次数。这是基于ipc接口上的规则

yarn.ipc.client.factory.class=null
创建客户端IPC类的工厂类

yarn.ipc.serializer.type=protocolbuffers
使用哪种序列化类

yarn.ipc.server.factory.class=null
创建IPC服务类的工厂类

yarn.ipc.exception.factory.class=null
创建IPC异常的工厂类

yarn.ipc.record.factory.class=null
创建序列化记录的工厂类

yarn.ipc.rpc.class=org.apache.hadoop.yarn.ipc.HadoopYarnProtoRPC
RPC类实现类

yarn.resourcemanager.client.thread-count=50
RM用来处理客户端请求的线程数

yarn.am.liveness-monitor.expiry-interval-ms=600000
AM报告间隔，毫秒。？

yarn.resourcemanager.principal=null
安全选项

yarn.resourcemanager.scheduler.client.thread-count=50
调度器用于处理请求的线程数

yarn.resourcemanager.webapp.address=0.0.0.0:8088
RM的网页接口地址：端口

yarn.resourcemanager.resource-tracker.address=0.0.0.0:8031
？

yarn.acl.enable=TRUE
开启访问控制

yarn.resourcemanager.admin.client.thread-count=1
RM管理端口处理事务的线程数

yarn.resourcemanager.amliveliness-monitor.interval-ms=1000
RM检查AM存活的间隔

yarn.resourcemanager.container.liveness-monitor.interval-ms=600000
检查container存活的时间间隔，毫秒。建议短一些，例如3分钟

yarn.resourcemanager.keytab=/etc/krb5.keytab
安全选项

yarn.nm.liveness-monitor.expiry-interval-ms=600000
RM判断NM死亡的时间间隔。
*非主动检查，被动等待，不连接时间超过此值
10分钟无检查到活动，判定NM死亡*

yarn.resourcemanager.nm.liveness-monitor.interval-ms=1000
RM检查NM存活的时间间隔。

yarn.resourcemanager.resource-tracker.client.thread-count=50
处理资源跟踪调用的线程数。？

yarn.resourcemanager.delayed.delegation-token.removal-interval-ms=30000
安全选项

yarn.resourcemanager.application-tokens.master-key-rolling-interval-secs=86400
安全选项

yarn.resourcemanager.container-tokens.master-key-rolling-interval-secs=86400
安全选项

yarn.nodemanager.admin-env=MALLOC_ARENA_MAX=$MALLOC_ARENA_MAX
应该从NM传送到container的环境变量

yarn.nodemanager.container-executor.class=org.apache.hadoop.yarn.server.nodemanager.DefaultContainerExecutor
启动containers的类。

yarn.nodemanager.container-manager.thread-count=20
用于container管理的线程数

yarn.nodemanager.delete.thread-count=4

### FAQ
- rcmd: socket: Permission denied
解决方法：
在/etc/pdsh下面新建文件rcmd_default，写入ssh，然后回车，记得一定要输入一个回车符另起一行，不然会提示ssh exit with code 1

- WARN org.apache.hadoop.yarn.server.nodemanager.containermanager.monitor.ContainersMonitorImpl: NodeManager configured with 8 G physical memory allocated to containers, which is more than 80% of the total physical memory available (1.8 G)
解决：编辑 $HADOOP_HOME/etc/hadoop/yarn-site.xml，加入以下配置：

<property>
    <name>yarn.nodemanager.resource.memory-mb</name>
    <value>1024</value>
</property>
<property>
    <name>yarn.scheduler.minimum-allocation-mb</name>
    <value>256</value>
</property>
<property>
    <name>yarn.scheduler.maximum-allocation-mb</name>
    <value>1024</value>
</property>
- requested resource type=[memory-mb] < 0 or greater than maximum allowed allocation
解决：
如果是mapreduce执行引擎，修改mapred-site.xml
<property>
<name>mapreduce.map.memory.mb</name>
<value>512</value>
</property>
<property>
<name>mapreduce.reduce.memory.mb</name>
<value>512</value>
</property>
<property>
<name>yarn.app.mapreduce.am.resource.mb</name>
<value>512</value>
</property>
同时yarn AM 也需要设置大小，默认情况下，yarn.app.mapreduce.am.resource.mb是2G，需要少于yarn.scheduler.maximum-allocation-mb的配置，这样才能成功启动。
https://blog.csdn.net/xuxiuning/article/details/51074127
- running beyond virtual memory limits. Current usage: 32.1mb of 1.0gb physical memory used; 6.2gb of 2.1gb virtual memory used. Killing container。
该错误是YARN的虚拟内存计算方式导致，上例中用户程序申请的内存为1Gb，YARN根据此值乘以一个比例（默认为2.1）得出申请的虚拟内存的 值，当YARN计算的用户程序所需虚拟内存值大于计算出来的值时，就会报出以上错误。调节比例值可以解决该问题。具体参数为：yarn-site.xml 中的yarn.nodemanayger.vmem-check-enabled
<property>
    <name>yarn.nodemanager.vmem-check-enabled</name>
    <value>false</value>
</property>
<property>
   <name>yarn.nodemanager.vmem-pmem-ratio</name>
    <value>5</value>
</property>


## hive
### 配置
```
cp hive-default.xml.template hive-site.xml
<property>
　　<name>javax.jdo.option.ConnectionURL</name>
　　<value>jdbc:mysql://localhost:3306/hive?createDatabaseIfNotExist=true</value>
</property>
<property>
　　<name>javax.jdo.option.ConnectionDriverName</name>
　　<value>com.mysql.jdbc.Driver</value>
</property>
<property>
　　<name>javax.jdo.option.ConnectionUserName</name>
　　<value>root</value>
</property>
<property>
　　<name>javax.jdo.option.ConnectionPassword</name>
　　<value>root</value>
</property>

<!--配置hiveserver2-->
  <property>
    <name>hive.server2.thrift.bind.host</name>
    <value>slave01</value>
    <description>Bind host on which to run the HiveServer2 Thrift service.</description>
  </property>

  <property>
    <name>hive.server2.thrift.port</name>
    <value>10000</value>
    <description>Port number of HiveServer2 Thrift interface when hive.server2.transport.mode is 'binary'.</description>
  </property>

  <property>
    <name>hive.server2.thrift.http.port</name>
    <value>10001</value>
    <description>Port number of HiveServer2 Thrift interface when hive.server2.transport.mode is 'http'.</description>
  </property>
<property>
    <name>hive.server2.thrift.client.user</name>
    <value>hadoop</value>
    <description>Username to use against thrift client</description>
  </property>
  <property>
    <name>hive.server2.thrift.client.password</name>
    <value>hadoop</value>
    <description>Password to use against thrift client</description>
  </property>
<!--解决权限拒绝-->
hadoop/etc/hadoop/core-site.xml

    <property>
    <name>hadoop.proxyuser.hadoop.hosts</name>
    <!--value>master</value-->
    <value>*</value>
    </property>

    <property>
    <name>hadoop.proxyuser.hadoop.groups</name>
    <!--value>hadoop</value-->
    <value>*</value>
    </property>
Hadoop.proxyuser.hadoop.hosts配置项名称中hadoop部分为报错User:* 中的用户名部分

替换system:java.io.tmpdir和system:user.name变量
cp hive-env.sh.template hive-env.sh
```
### 初始化
```
./schematool -initSchema -dbType mysql
```
### 启动hiveserver2
```

启动hiveserver2,   # nohup hive --service hiveserver2 & 
beeline -u jdbc:hive2://localhost:10000 -n hadoop
select count(*),species from iris group by species;
```


