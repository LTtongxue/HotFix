.class public Lcom/hengda/andfix/AndFixActivity_CF;
.super Landroid/support/v7/app/AppCompatActivity;
.source "AndFixActivity.java"


# static fields
.field private static final FILE_END:Ljava/lang/String; = ".apatch"

.field private static final TAG:Ljava/lang/String; = "AndFixActivity"


# instance fields
.field private mPathDir:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public createBug(Landroid/view/View;)V
    .locals 0
    .annotation runtime Lcom/alipay/euler/andfix/annotation/MethodReplace;
        clazz = "com.hengda.andfix.AndFixActivity"
        method = "createBug"
    .end annotation

    const-string p1, "bug\u4fee\u590d\u5566\uff01"

    .line 32
    invoke-static {p0, p1}, Lcom/hengda/andfix/Utils;->show(Landroid/content/Context;Ljava/lang/String;)V

    return-void
.end method

.method public fixBug(Landroid/view/View;)V
    .locals 1

    .line 36
    invoke-static {}, Lcom/hengda/andfix/AndFixPatchManager;->getInstance()Lcom/hengda/andfix/AndFixPatchManager;

    move-result-object p1

    invoke-virtual {p0}, Lcom/hengda/andfix/AndFixActivity_CF;->getPatchName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/hengda/andfix/AndFixPatchManager;->addPatch(Ljava/lang/String;)V

    return-void
.end method

.method public getPatchName()Ljava/lang/String;
    .locals 2

    .line 41
    iget-object v0, p0, Lcom/hengda/andfix/AndFixActivity_CF;->mPathDir:Ljava/lang/String;

    const-string v1, "andfix"

    invoke-virtual {v0, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, ".apatch"

    invoke-virtual {v0, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2

    .line 17
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    const p1, 0x7f09001c

    .line 18
    invoke-virtual {p0, p1}, Lcom/hengda/andfix/AndFixActivity_CF;->setContentView(I)V

    .line 20
    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/hengda/andfix/AndFixActivity_CF;->getExternalCacheDir()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, "/apatch/"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/hengda/andfix/AndFixActivity_CF;->mPathDir:Ljava/lang/String;

    const-string p1, "AndFixActivity"

    .line 21
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "onCreate: mPathDir == "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/hengda/andfix/AndFixActivity_CF;->mPathDir:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 23
    new-instance p1, Ljava/io/File;

    iget-object v0, p0, Lcom/hengda/andfix/AndFixActivity_CF;->mPathDir:Ljava/lang/String;

    invoke-direct {p1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 24
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_0

    .line 25
    invoke-virtual {p1}, Ljava/io/File;->mkdir()Z

    :cond_0
    return-void
.end method
